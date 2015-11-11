/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class DefaultFreshBooksOAuthClient implements FreshBooksOAuthClient {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFreshBooksOAuthClient.class);

    private String requestToken;
    private String requestTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private ObjectStoreHelper objectStoreHelper;

    public DefaultFreshBooksOAuthClient(String consumerKey, String consumerSecret, ObjectStore objectStoreRef) {
        Validate.notEmpty(consumerKey);
        Validate.notEmpty(consumerSecret);
        setConsumerKey(consumerKey);
        setConsumerSecret(consumerSecret);
        objectStoreHelper = new ObjectStoreHelper(objectStoreRef);
    }

    /**
     * Retrieves a request token using requestTokenId as identifier If the app doesn't provide a requestToken the method will generate an UUID and send it as a callback parameter
     * to the service.
     */
    @Override
    public String authorize(String requestTokenUrl, String accessTokenUrl, String authorizationUrl, String callbackUrl, String requestTokenId) throws OAuthMessageSignerException,
            OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException, ObjectStoreException {

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

        logger.debug(String.format("Retrieving OAuth requestToken [consumerKey = %s] [consumerSecret = %s] [callbackUrl = %s]", consumerKey, consumerSecret, callbackUrl));

        String authTokenUrl = provider.retrieveRequestToken(consumer, callbackUrl);

        logger.debug(String.format("Request Token INFO [authTokenUrl = %s] [requestToken = %s] [requestTokenSecret = %s]", authTokenUrl, consumer.getToken(),
                consumer.getTokenSecret()));

        setRequestToken(consumer.getToken());
        setRequestTokenSecret(consumer.getTokenSecret());

        // Stores the request token
        objectStoreHelper.store(requestTokenId, new OAuthCredentials(consumer.getToken(), consumer.getTokenSecret(), requestTokenUrl, accessTokenUrl, authorizationUrl), true);

        logger.debug("Request Token stored");
        return authTokenUrl;
    }

    /**
     * Gets an access token using the request token stored in the ObjectStore instance. The requestTokenId is provided by the app.
     */
    @Override
    public OAuthCredentials getAccessToken(String verifier, String requestTokenId) throws OAuthMessageSignerException, OAuthNotAuthorizedException,
            OAuthExpectationFailedException, OAuthCommunicationException, ObjectStoreException {

        logger.debug(String.format("Trying to retrieve request token information [requestTokenId = %s]", requestTokenId));

        // Retrieves requestToken and requestTokenSecret
        OAuthCredentials credentials = (OAuthCredentials) objectStoreHelper.retrieve(requestTokenId);
        logger.debug(String.format("Retrieved request token INFO [requestToken = %s] [requestTokenSecret = %s]", credentials.getAccessToken(), credentials.getAccessTokenSecret()));

        OAuthConsumer consumer = new DefaultOAuthConsumer(getConsumerKey(), getConsumerSecret());

        OAuthProvider provider = new DefaultOAuthProvider(credentials.getRequestTokenUrl(), credentials.getAccessTokenUrl(), credentials.getAuthUrl());
        provider.setOAuth10a(true);
        consumer.setMessageSigner(new PlainTextMessageSigner());

        consumer.setTokenWithSecret(credentials.getAccessToken(), credentials.getAccessTokenSecret());
        provider.retrieveAccessToken(consumer, verifier);
        logger.debug(String.format("Token authenticated successfully: [verifier = %s]", verifier));

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
