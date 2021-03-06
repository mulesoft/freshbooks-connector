/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;
import oauth.signpost.signature.PlainTextMessageSigner;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mule.modules.freshbooks.exception.FreshBooksException;
import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Paged;
import org.mule.modules.freshbooks.model.Response;
import org.mule.modules.freshbooks.util.MessageUtils;
import org.mule.modules.utils.pagination.PaginatedIterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultFreshBooksClient implements FreshBooksClient {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFreshBooksClient.class);

    private final URL apiUrl;
    private transient DefaultHttpClient client;
    private String consumerKey;
    private String consumerSecret;

    public DefaultHttpClient getClient() {
        return client;
    }

    /**
     * Constructor for Authentication Token mechanism
     * 
     * @param apiUrl
     *            url for API
     * @param authenticationToken
     *            authentication token value
     * @param maxTotalConnection
     *            max total connections for client
     * @param defaultMaxConnectionPerRoute
     *            default max connection per route for client
     */
    public DefaultFreshBooksClient(String apiUrl, String authenticationToken, int maxTotalConnection, int defaultMaxConnectionPerRoute) {
        Validate.notEmpty(apiUrl);
        Validate.notEmpty(authenticationToken);
        try {
            this.apiUrl = new URL(apiUrl);
        } catch (MalformedURLException e) {
            throw new FreshBooksException(e.getMessage());
        }

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
        // max total connections
        cm.setMaxTotal(maxTotalConnection);
        // default max connection per route
        cm.setDefaultMaxPerRoute(defaultMaxConnectionPerRoute);

        client = new DefaultHttpClient(cm);
        this.client.getCredentialsProvider().setCredentials(new AuthScope(this.apiUrl.getHost(), 443, AuthScope.ANY_REALM),
                new UsernamePasswordCredentials(authenticationToken, ""));

        client.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount > 3) {
                    logger.warn("Maximum tries reached for client http pool ");
                    return false;
                }
                if (exception instanceof org.apache.http.NoHttpResponseException) {
                    logger.warn("No response from server on " + executionCount + " call");
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * Constructor for OAuth1.0a mechanism
     * 
     * @param apiUrl
     *            url for API
     * @param consumerKey
     *            consumerKey value
     * @param consumerSecret
     *            consumerSecret value
     * @param maxTotalConnection
     *            max total connections for client
     * @param defaultMaxConnectionPerRoute
     *            default max connection per route for client
     */
    public DefaultFreshBooksClient(String apiUrl, String consumerKey, String consumerSecret, int maxTotalConnection, int defaultMaxConnectionPerRoute) {
        Validate.notEmpty(apiUrl);

        try {
            this.apiUrl = new URL(apiUrl);
        } catch (MalformedURLException e) {
            throw new FreshBooksException(e.getMessage());
        }

        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
        // max total connections
        cm.setMaxTotal(maxTotalConnection);
        // default max connection per route
        cm.setDefaultMaxPerRoute(defaultMaxConnectionPerRoute);

        client = new DefaultHttpClient(cm);
        client.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount > 3) {
                    logger.warn("Maximum tries reached for client http pool ");
                    return false;
                }
                if (exception instanceof org.apache.http.NoHttpResponseException) {
                    logger.warn("No response from server on " + executionCount + " call");
                    return true;
                }
                return false;
            }
        });
    }

    private Response sendRequest(OAuthCredentials credentials, BaseRequest request) {
        Validate.notNull(credentials);
        String requestString = marshalRequest(request);

        URL apiUrlBase = apiUrl;

        // The client will use the API url if it's in the credentials
        if (StringUtils.isNotBlank(credentials.getApiUrl())) {
            try {
                apiUrlBase = new URL(credentials.getApiUrl());
            } catch (MalformedURLException e) {
                throw new FreshBooksException(e.getMessage());
            }
        }

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(this.consumerKey, this.consumerSecret);
        consumer.setMessageSigner(new PlainTextMessageSigner());
        consumer.setTokenWithSecret(credentials.getAccessToken(), credentials.getAccessTokenSecret());
        consumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());

        logger.debug(String.format("Signing OAuth request [accessToken = %s] [accessTokenSecret = %s] ", consumer.getToken(), consumer.getTokenSecret()));
        logger.debug(String.format("API parameters [apiURL = %s]", apiUrlBase));

        Response response;
        HttpUriRequest uriRequest = new HttpPost(apiUrlBase.toString());
        try {
            ((HttpPost) uriRequest).setEntity(new StringEntity(requestString, "utf-8"));
            uriRequest.addHeader("Content-Type", "text/xml");

            consumer.sign(uriRequest);

            HttpResponse httpResponse = client.execute(uriRequest);
            InputStream is = httpResponse.getEntity().getContent();
            response = unmarshalResponse(is);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new FreshBooksException(e);
        } finally {
            ((HttpPost) uriRequest).releaseConnection();
        }
        if (!"ok".equals(response.getStatus())) {
            throw new FreshBooksException(response.getError());
        }
        return response;
    }

    private Response unmarshalResponse(InputStream is) {
        try {
            return (Response) MessageUtils.getInstance().parseResponse(getResourceAsString(is));
            // return (BaseResponse) type.getResponseClass().getDeclaredConstructor(Response.class).newInstance(response);
        } catch (Exception e) {
            throw new FreshBooksException(e);
        }
    }

    private String marshalRequest(BaseRequest request) {
        @SuppressWarnings("rawtypes")
        JAXBElement jaxbElement = MessageUtils.getInstance().createJaxbElement(request);
        try {
            return MessageUtils.getInstance().getXmlDocument(jaxbElement);
        } catch (JAXBException e) {
            throw new FreshBooksException(e);
        }
    }

    @Override
    public Object create(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId) {
        return requestSendingObject(credentials, sourceToken, type, obj, "create", returnOnlyId);
    }

    @Override
    public void update(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId) {
        requestSendingObject(credentials, sourceToken, type, obj, "update", returnOnlyId);
    }

    private Object requestSendingObject(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, String typeOfRequest, Boolean returnOnlyId) {
        BaseRequest request = type.getRequest();

        if (StringUtils.isNotBlank(sourceToken)) {
            request.setSourceToken(sourceToken);
        }

        try {
            request.getClass().getMethod("set" + type.getSimpleName(), type.getType()).invoke(request, obj);
        } catch (Exception e) {
            throw new FreshBooksException(e.getMessage());
        }

        request.setMethod(type.getResourceName() + "." + typeOfRequest);

        Response response = sendRequest(credentials, request);
        String getMethod = "get" + type.getSimpleName();
        try {
            if (returnOnlyId) {
                getMethod = getMethod + "Id";
            }
            return response.getClass().getMethod(getMethod).invoke(response);
        } catch (Exception e) {
            throw new FreshBooksException(e.getMessage());
        }
    }

    @Override
    public Object get(OAuthCredentials credentials, String sourceToken, EntityType type, String id) {
        return requestSendingId(credentials, sourceToken, type, id, "get");
    }

    @Override
    public void delete(OAuthCredentials credentials, String sourceToken, EntityType type, String id) {
        requestSendingId(credentials, sourceToken, type, id, "delete");
    }

    @Override
    public void undelete(OAuthCredentials credentials, String sourceToken, EntityType type, String id) {
        requestSendingId(credentials, sourceToken, type, id, "undelete");
    }

    @Override
    public void verify(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId) {
        requestSendingObject(credentials, sourceToken, type, obj, "verify", returnOnlyId);
    }

    @Override
    public Object execute(OAuthCredentials credentials, String sourceToken, EntityType type, String operation) {
        BaseRequest request = type.getRequest();

        if (StringUtils.isNotBlank(sourceToken)) {
            request.setSourceToken(sourceToken);
        }

        request.setMethod(operation);
        Response response = sendRequest(credentials, request);
        try {
            return response.getClass().getMethod("get" + type.getSimpleName()).invoke(response);
        } catch (Exception e) {
            throw new FreshBooksException(e.getMessage());
        }
    }

    private Object requestSendingId(OAuthCredentials credentials, String sourceToken, EntityType type, String id, String typeOfRequest) {
        BaseRequest request = type.getRequest();

        if (StringUtils.isNotBlank(sourceToken)) {
            request.setSourceToken(sourceToken);
        }

        try {
            request.getClass().getMethod("set" + type.getSimpleName() + "Id", String.class).invoke(request, id);
        } catch (Exception e) {
            throw new FreshBooksException(e.getMessage());
        }

        request.setMethod(type.getResourceName() + "." + typeOfRequest);

        Response response = sendRequest(credentials, request);
        try {
            return response.getClass().getMethod("get" + type.getSimpleName()).invoke(response);
        } catch (Exception e) {
            throw new FreshBooksException(e.getMessage());
        }
    }

    @Override
    public <T> Iterable<T> listPaged(final OAuthCredentials credentials, final String sourceToken, final EntityType type, final BaseRequest request) {
        return new PaginatedIterable<T, Paged<T>>() {

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
                return askAnEspecificPage(arg0.getPage() + 1);
            }

            @Override
            protected Iterator<T> pageIterator(Paged<T> arg0) {
                return arg0.iterator();
            }

            @SuppressWarnings("unchecked")
            private Paged<T> askAnEspecificPage(Integer pageNumber) {

                if (StringUtils.isNotBlank(sourceToken)) {
                    request.setSourceToken(sourceToken);
                }

                request.setMethod(type.getResourceName() + ".list");
                request.setPage(pageNumber);

                Response response = sendRequest(credentials, request);
                try {
                    return (Paged<T>) response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
                } catch (Exception e) {
                    throw new FreshBooksException(e.getMessage());
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Iterable<T> list(OAuthCredentials credentials, String sourceToken, final EntityType type, final BaseRequest request) {
        Integer pageNumber = 0;
        Boolean hasMoreResults = true;
        List<T> listOfResults = new ArrayList<T>();
        Paged<T> results;

        request.setMethod(type.getResourceName() + ".list");

        if (StringUtils.isNotBlank(sourceToken)) {
            request.setSourceToken(sourceToken);
        }

        while (hasMoreResults) {

            pageNumber++;
            request.setPage(pageNumber);

            Response response = sendRequest(credentials, request);

            try {
                results = (Paged<T>) response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
            } catch (IllegalArgumentException | SecurityException | FreshBooksException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new FreshBooksException(e.getMessage());
            }

            hasMoreResults = results.getTotal() > (results.getPerPage() * pageNumber);

            listOfResults.addAll(results.getContents());
        }

        return listOfResults;
    }

    @Override
    public Object getListObject(OAuthCredentials credentials, String sourceToken, final EntityType type, final BaseRequest request) {
        request.setMethod(type.getResourceName() + ".list");

        if (StringUtils.isNotBlank(sourceToken)) {
            request.setSourceToken(sourceToken);
        }

        Response response = sendRequest(credentials, request);

        try {
            return response.getClass().getMethod("get" + type.getNameForLists()).invoke(response);
        } catch (IllegalArgumentException e) {
            throw new FreshBooksException(e.getMessage());
        } catch (SecurityException e) {
            throw new FreshBooksException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new FreshBooksException(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new FreshBooksException(e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new FreshBooksException(e.getMessage());
        }
    }

    private static String getResourceAsString(InputStream in) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(in, writer, "UTF-8");
        return writer.toString();
    }

    public URL getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return consumerKey;
    }

    public String getApiSecret() {
        return consumerSecret;
    }

    public void setApiKey(String apiKey) {
        this.consumerKey = apiKey;
    }

    public void setApiSecret(String apiSecret) {
        this.consumerSecret = apiSecret;
    }
}
