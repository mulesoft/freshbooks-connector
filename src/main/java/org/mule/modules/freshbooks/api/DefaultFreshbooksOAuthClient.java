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

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.signature.PlainTextMessageSigner;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;

@SuppressWarnings("rawtypes") 
public class DefaultFreshbooksOAuthClient implements FreshbooksOAuthClient
{
    private static final Logger LOGGER = Logger.getLogger(DefaultFreshbooksOAuthClient.class);

    private String requestToken;
    private String requestTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private ObjectStoreHelper objectStoreHelper;
    
    public DefaultFreshbooksOAuthClient(String consumerKey, String consumerSecret, ObjectStore objectStoreRef) 
    {
        Validate.notEmpty(consumerKey);
        Validate.notEmpty(consumerSecret);        
        setConsumerKey(consumerKey);
        setConsumerSecret(consumerSecret);
        objectStoreHelper = new ObjectStoreHelper(objectStoreRef);
    }

    /**
     * Retrieves a request token using requestTokenId as identifier
     * If the app doesn't provide a requestToken the method will generate an UUID 
     * and send it as a callback parameter to the service.
     */
    @Override
    public String authorize(String requestTokenUrl, String accessTokenUrl, String authorizationUrl, 
            String callbackUrl, String requestTokenId)
            throws OAuthMessageSignerException, OAuthNotAuthorizedException, 
            OAuthExpectationFailedException, OAuthCommunicationException, ObjectStoreException {
        
        OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey, consumerSecret);
        OAuthProvider provider = new DefaultOAuthProvider(requestTokenUrl, accessTokenUrl, authorizationUrl);
        provider.setOAuth10a(true);
        consumer.setMessageSigner(new PlainTextMessageSigner());
        setConsumerKey(consumerKey);
        setConsumerSecret(consumerSecret);

        if (StringUtils.isBlank(requestTokenId)) {
            requestTokenId = org.mule.util.UUID.getUUID();
        }

        callbackUrl = callbackUrl.concat("?userId=" + requestTokenId);

        if (LOGGER.isDebugEnabled()) {
            StringBuilder messageStringBuilder = new StringBuilder();
            messageStringBuilder.append("Retrieving OAuth requestToken ");
            messageStringBuilder.append("[consumerKey = ");
            messageStringBuilder.append(consumerKey);
            messageStringBuilder.append("] ");
            messageStringBuilder.append("[consumerSecret = ");
            messageStringBuilder.append(consumerSecret);
            messageStringBuilder.append("] ");
            messageStringBuilder.append("[callbackUrl = ");
            messageStringBuilder.append(callbackUrl);
            messageStringBuilder.append("] ");
            LOGGER.debug(messageStringBuilder.toString());
        }

        String authTokenUrl = provider.retrieveRequestToken(consumer, callbackUrl);
        
        if (LOGGER.isDebugEnabled()) {
            StringBuilder messageStringBuilder = new StringBuilder();
            messageStringBuilder.append("Request Token INFO ");
            messageStringBuilder.append("[authTokenUrl = ");
            messageStringBuilder.append(authTokenUrl);
            messageStringBuilder.append("] ");
            messageStringBuilder.append("[requestToken = ");
            messageStringBuilder.append(consumer.getToken());
            messageStringBuilder.append("] ");
            messageStringBuilder.append("[requestTokenSecret = ");
            messageStringBuilder.append(consumer.getTokenSecret());
            messageStringBuilder.append("] ");
            LOGGER.debug(messageStringBuilder.toString());
        }

        setRequestToken(consumer.getToken());
        setRequestTokenSecret(consumer.getTokenSecret());

        //Stores the request token
        objectStoreHelper.store(requestTokenId, 
                new OAuthCredentials(consumer.getToken(), consumer.getTokenSecret(), requestTokenUrl, 
                        accessTokenUrl, authorizationUrl), true);

        LOGGER.debug("Request Token stored");
        return authTokenUrl;
    }

    /**
     * Gets an access token using the request token stored in the ObjectStore instance.
     * The requestTokenId is provided by the app.
     */
    @Override
    public OAuthCredentials getAccessToken(String verifier, String requestTokenId) 
            throws OAuthMessageSignerException, OAuthNotAuthorizedException, 
            OAuthExpectationFailedException, OAuthCommunicationException, ObjectStoreException {
        
        if (LOGGER.isDebugEnabled()) {
            StringBuilder messageStringBuilder = new StringBuilder();
            messageStringBuilder.append("Trying to retrieve request token information ");
            messageStringBuilder.append("[requestTokenId = ");
            messageStringBuilder.append(requestTokenId);
            messageStringBuilder.append("] ");
            LOGGER.debug(messageStringBuilder.toString());
        }
        
        //Retrieves requestToken and requestTokenSecret
        OAuthCredentials credentials = (OAuthCredentials) objectStoreHelper.retrieve(requestTokenId);
        if (LOGGER.isDebugEnabled()) {
            StringBuilder messageStringBuilder = new StringBuilder();
            messageStringBuilder.append("Retrieved request token INFO ");
            messageStringBuilder.append("[requestToken = ");
            messageStringBuilder.append(credentials.getAccessToken());
            messageStringBuilder.append("] ");
            messageStringBuilder.append("[requestTokenSecret = ");
            messageStringBuilder.append(credentials.getAccessTokenSecret());
            messageStringBuilder.append("] ");
            LOGGER.debug(messageStringBuilder.toString());
        }
        
        OAuthConsumer consumer = new DefaultOAuthConsumer(getConsumerKey(), getConsumerSecret());

        OAuthProvider provider = new DefaultOAuthProvider(credentials.getRequestTokenUrl(), 
                credentials.getAccessTokenUrl(), credentials.getAuthUrl());        
        provider.setOAuth10a(true);
        consumer.setMessageSigner(new PlainTextMessageSigner());

        consumer.setTokenWithSecret(credentials.getAccessToken(), credentials.getAccessTokenSecret());
        provider.retrieveAccessToken(consumer, verifier);
        if (LOGGER.isDebugEnabled()) {
            StringBuilder messageStringBuilder = new StringBuilder();
            messageStringBuilder.append("Token authenticated successfully: ");
            messageStringBuilder.append("[verifier = ");
            messageStringBuilder.append(verifier);
            messageStringBuilder.append("] ");
            LOGGER.debug(messageStringBuilder.toString());
        }

        credentials.setAccessToken(consumer.getToken());
        credentials.setAccessTokenSecret(consumer.getTokenSecret());
        return credentials;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public String getRequestTokenSecret() {
        return requestTokenSecret;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public void setRequestTokenSecret(String requestTokenSecret) {
        this.requestTokenSecret = requestTokenSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public ObjectStoreHelper getObjectStoreHelper() {
        return objectStoreHelper;
    }

    public void setObjectStoreHelper(ObjectStoreHelper objectStoreHelper) {
        this.objectStoreHelper = objectStoreHelper;
    }
}
