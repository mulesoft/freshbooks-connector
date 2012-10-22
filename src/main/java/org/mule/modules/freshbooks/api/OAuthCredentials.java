/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.api;

import java.io.Serializable;

public class OAuthCredentials implements Serializable {

    private static final long serialVersionUID = 1L;
    private String accessToken;
    private String accessTokenSecret;
    private String userId;
    private String requestTokenUrl;
    private String authUrl;
    private String accessTokenUrl;
    private String apiUrl;

    public OAuthCredentials() {
        
    }
    
    public OAuthCredentials(String accessToken, String accessTokenSecret) {
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }
    
    public OAuthCredentials(String accessToken, String accessTokenSecret, String requestTokenUrl,
            String accessTokenUrl, String authUrl) {
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        this.requestTokenUrl = requestTokenUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.authUrl = authUrl;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getRequestTokenUrl() {
        return requestTokenUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setRequestTokenUrl(String requestTokenUrl) {
        this.requestTokenUrl = requestTokenUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
