/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

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
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Paged;
import org.mule.modules.freshbooks.model.Response;
import org.mule.modules.utils.pagination.PaginatedIterable;

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

    private Response sendRequest(BaseRequest request) 
    {
        String requestString = marshalRequest(request);

        Response response;
        PostMethod method = new PostMethod(apiUrl.toString());
        try {
            method.setContentChunked(false);
            method.setDoAuthentication(true);
            method.setFollowRedirects(false);
            method.setRequestEntity(new StringRequestEntity(requestString, "text/xml", "utf-8"));
            method.getParams().setContentCharset("utf-8");

            client.executeMethod(method);
            InputStream is = method.getResponseBodyAsStream();
            response = unmarshalResponse(is);
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

    private Response unmarshalResponse(InputStream is) 
    {
        try {
            return (Response) FreshbooksMessageUtils.getInstance().parseResponse(getResourceAsString(is));
            //return (BaseResponse) type.getResponseClass().getDeclaredConstructor(Response.class).newInstance(response);
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

        Response response = sendRequest(request);
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

        Response response = sendRequest(request);
        try {
            return response.getClass().getMethod("get" + type.getSimpleName()).invoke(response);
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
    }
    
    @Override
    public <T> Iterable<T> list(final EntityType type, final BaseRequest request) 
    {
        return new PaginatedIterable<T, Paged<T>>(){

            @Override
            protected Paged<T> firstPage() {
                return askAnEspecificPage(1);
            }

            @Override
            protected boolean hasNextPage(Paged<T> arg0) {
                return arg0.getPage() < arg0.getPages();
            }

            @Override
            protected Paged<T> nextPage(Paged<T> arg0) {
                return askAnEspecificPage(arg0.getPage()+1);
            }

            @Override
            protected Iterator<T> pageIterator(Paged<T> arg0) {
                return arg0.iterator();
            }
            
            private Paged<T> askAnEspecificPage(Integer pageNumber) {
                request.setMethod(type.getResourceName() + ".list");
                request.setPage(pageNumber);
                
                Response response = sendRequest(request);
                try {
                    return (Paged<T>) response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
                } catch (Exception e) {
                    throw new FreshbooksException(e.getMessage());
                }
            }
        };
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
