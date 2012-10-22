/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.api;

import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.EntityType;

public interface FreshbooksClient {
    
    public Object create(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public void update(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public Object get(OAuthCredentials credentials, String sourceToken, EntityType type, String id);
    
    public void delete(OAuthCredentials credentials, String sourceToken, EntityType type, String id);
    
    public void verify(OAuthCredentials credentials, String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public <T> Iterable<T> list(OAuthCredentials credentials, String sourceToken, EntityType type, BaseRequest request);
    
    public Object getListObject(OAuthCredentials credentials, 
            String sourceToken, EntityType type, BaseRequest request);

    public <T> Iterable<T> listPaged(OAuthCredentials credentials, String sourceToken, EntityType type, BaseRequest request);
    
    public void undelete(OAuthCredentials credentials, String sourceToken, EntityType type, String id);

    Object execute(OAuthCredentials credentials, String sourceToken, EntityType type, String operation);
}
