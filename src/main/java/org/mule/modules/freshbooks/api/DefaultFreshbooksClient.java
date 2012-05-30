package org.mule.modules.freshbooks.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.mule.modules.freshbooks.FreshbooksException;
import org.mule.modules.freshbooks.XMLNamespaceFilter;
import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.BaseResponse;
import org.mule.modules.freshbooks.model.EntityType;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

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
        try {
            String requestString = marshalRequest(request);

            PostMethod method = new PostMethod(apiUrl.toString());
            try {
                method.setContentChunked(false);
                method.setDoAuthentication(true);
                method.setFollowRedirects(false);
                method.setRequestEntity(new StringRequestEntity(requestString, "text/xml", "utf-8"));
                method.getParams().setContentCharset("utf-8");

                client.executeMethod(method);
                InputStream is = method.getResponseBodyAsStream();
                BaseResponse response = unmarshalResponse(type, is);
                if (!"ok".equals(response.getStatus())) {
                    throw new FreshbooksException(response.getError());
                }
                return response;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                throw new FreshbooksException(e);
            } finally {
                method.releaseConnection();
            }
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
            throw new FreshbooksException(e);
        }
    }

    private BaseResponse unmarshalResponse(EntityType type, InputStream is) throws JAXBException, SAXException, ParserConfigurationException 
    {
        JAXBContext jc = JAXBContext.newInstance(type.getResponseClass());
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        // Create the XMLReader
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader reader = factory.newSAXParser().getXMLReader();

        // The filter class to set the correct namespace
        XMLFilterImpl xmlFilter = new XMLNamespaceFilter(reader);
        reader.setContentHandler(unmarshaller.getUnmarshallerHandler());
        SAXSource source = new SAXSource(xmlFilter, new InputSource(is));

        return (BaseResponse) unmarshaller.unmarshal(source);
    }

    private String marshalRequest(BaseRequest request) throws JAXBException 
    {
        JAXBContext jc = JAXBContext.newInstance(BaseRequest.class);
        Marshaller marshaller = jc.createMarshaller();
        OutputStream requestStream = new OutputStream() {
            private final StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            //Netbeans IDE automatically overrides this toString()
            @Override
            public String toString() {
                return this.string.toString();
            }
        };

        marshaller.marshal(request, requestStream);
        return requestStream.toString();
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
}