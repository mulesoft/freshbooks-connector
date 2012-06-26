package org.mule.modules.freshbooks.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.mule.modules.freshbooks.FreshbooksException;
import org.mule.modules.freshbooks.FreshbooksMessageUtils;
import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.BaseResponse;
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Response;

public class DefaultFreshbooksClient implements FreshbooksClient
{
    private static final Logger LOGGER = Logger.getLogger(DefaultFreshbooksClient.class);

    private final URL apiUrl;
    private transient HttpClient client;
    
    public DefaultFreshbooksClient(String apiUrl, String authenticationToken) 
    {
        Validate.notEmpty(apiUrl);
        Validate.notEmpty(authenticationToken);
        try {
            this.apiUrl = new URL(apiUrl);
        } catch (MalformedURLException e) {
            throw new FreshbooksException(e.getMessage());
        }
        this.client = new HttpClient();
        this.client.getParams().setAuthenticationPreemptive(true);
        this.client.getState().setCredentials(new AuthScope(this.apiUrl.getHost(), 443, AuthScope.ANY_REALM), new UsernamePasswordCredentials(authenticationToken, ""));
    }

    private BaseResponse sendRequest(EntityType type, BaseRequest request) 
    {
        String requestString = marshalRequest(request);

        BaseResponse response;
        PostMethod method = new PostMethod(apiUrl.toString());
        try {
            method.setContentChunked(false);
            method.setDoAuthentication(true);
            method.setFollowRedirects(false);
            method.setRequestEntity(new StringRequestEntity(requestString, "text/xml", "utf-8"));
            method.getParams().setContentCharset("utf-8");

            client.executeMethod(method);
            InputStream is = method.getResponseBodyAsStream();
            response = unmarshalResponse(type, is);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new FreshbooksException(e);
        } finally {
            method.releaseConnection();
        }
        if (!"ok".equals(response.getStatus())) {
            throw new FreshbooksException(response.getError());
        }
        return response;
    }

    private BaseResponse unmarshalResponse(EntityType type, InputStream is) 
    {
        Response response;
        try {
            response = (Response) FreshbooksMessageUtils.getInstance().parseResponse(getResourceAsString(is));
            return (BaseResponse) type.getResponseClass().getDeclaredConstructor(Response.class).newInstance(response);
        } catch (Exception e) {
            throw new FreshbooksException(e);
        }
    }

    private String marshalRequest(BaseRequest request)
    {
        JAXBElement jaxbElement = FreshbooksMessageUtils.getInstance().createJaxbElement(request);
        try {
            return FreshbooksMessageUtils.getInstance().getXmlDocument(jaxbElement);
        } catch (JAXBException e) {
            throw new FreshbooksException(e);
        }
    }
    
    @Override
    public String create(EntityType type, Object obj) 
    {
        return requestSendingObject(type, obj, "create");
    }

    @Override
    public void update(EntityType type, Object obj)
    {
        requestSendingObject(type, obj, "update");
    }
    
    private String requestSendingObject(EntityType type, Object obj, String typeOfRequest)
    {
        BaseRequest request = type.getRequest();
        
        try {
            request.getClass().getMethod("set" + type.getSimpleName(), type.getType()).invoke(request, obj);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
        
        request.setMethod(type.getResourceName() + "." + typeOfRequest);

        BaseResponse response = sendRequest(type, request);
        try {
            return (String) response.getClass().getMethod("get" + type.getSimpleName() + "Id").invoke(response);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
    }

    @Override
    public Object get(EntityType type, String id) 
    {
        return requestSendingId(type, id, "get");
    }

    @Override
    public void delete(EntityType type, String id) 
    {
        requestSendingId(type, id, "delete");
    }

    private Object requestSendingId(EntityType type, String id, String typeOfRequest)
    {
        BaseRequest request = type.getRequest();
        
        try {
            request.getClass().getMethod("set" + type.getSimpleName() + "Id", String.class).invoke(request, id);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
        
        request.setMethod(type.getResourceName() + "." + typeOfRequest);

        BaseResponse response = sendRequest(type, request);
        try {
            return response.getClass().getMethod("get" + type.getSimpleName()).invoke(response);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
    }
    
    @Override
    public Object list(EntityType type) 
    {
        BaseRequest request = type.getRequest();
        request.setMethod(type.getResourceName() + ".list");

        BaseResponse response = sendRequest(type, request);
        try {
            return response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
    }
    
    private static String getResourceAsString(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        byte[] buf = new byte[1024];
        int sz = 0;
        try {
            while (true) {
                sz = in.read(buf);

                baos.write(buf, 0, sz);
                if (sz < buf.length)
                    break;
            }
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        }
        return new String(baos.toByteArray());
    }
}
