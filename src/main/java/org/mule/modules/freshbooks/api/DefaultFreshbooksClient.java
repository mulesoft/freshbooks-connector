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

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.io.IOUtils;
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
    private transient DefaultHttpClient client;
    
    public DefaultFreshbooksClient(String apiUrl, String authenticationToken) 
    {
        Validate.notEmpty(apiUrl);
        Validate.notEmpty(authenticationToken);
        try {
            this.apiUrl = new URL(apiUrl);
        } catch (MalformedURLException e) {
            throw new FreshbooksException(e.getMessage());
        }
        this.client = new DefaultHttpClient();
        this.client.getCredentialsProvider().setCredentials(new AuthScope(this.apiUrl.getHost(), 443, AuthScope.ANY_REALM), new UsernamePasswordCredentials(authenticationToken, ""));
    }

    private Response sendRequest(BaseRequest request) 
    {
        String requestString = marshalRequest(request);

        Response response;
        HttpUriRequest uriRequest = new HttpPost(apiUrl.toString());
        try {
            ((HttpPost) uriRequest).setEntity(new StringEntity(requestString, "utf-8"));
            uriRequest.addHeader("Content-Type", "text/xml");
            
            HttpResponse httpResponse = client.execute(uriRequest);
            InputStream is = httpResponse.getEntity().getContent();
            response = unmarshalResponse(is);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new FreshbooksException(e);
        } finally {
            ((HttpPost) uriRequest).releaseConnection();
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
    public <T> Iterable<T> listPaged(final EntityType type, final BaseRequest request) 
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
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> Iterable<T> list(final EntityType type, final BaseRequest request) 
    {
        Integer pageNumber = 0;
        Boolean hasMoreResults = true;
        List<T> listOfResults = new ArrayList<T>();
        Paged<T> results;

        request.setMethod(type.getResourceName() + ".list");
        
        while(hasMoreResults) {
            
            pageNumber++;
            request.setPage(pageNumber);
            
            Response response = sendRequest(request);            

            try {
                results = (Paged<T>) response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
            } catch (IllegalArgumentException e) {
                throw new FreshbooksException(e.getMessage());
            } catch (SecurityException e) {
                throw new FreshbooksException(e.getMessage());
            } catch (IllegalAccessException e) {
                throw new FreshbooksException(e.getMessage());
            } catch (InvocationTargetException e) {
                throw new FreshbooksException(e.getMessage());
            } catch (NoSuchMethodException e) {
                throw new FreshbooksException(e.getMessage());
            }
            
            hasMoreResults = results.getTotal() >= results.getPerPage(); 
            
            listOfResults.addAll(results.getContents());
        }
        
        return listOfResults;
    }
    
    private static String getResourceAsString(InputStream in) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(in, writer, "UTF-8");
        return writer.toString();
    }
}
