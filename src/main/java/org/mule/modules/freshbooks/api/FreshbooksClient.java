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

import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.EntityType;

public interface FreshbooksClient {
    
    public Object create(String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public void update(String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public Object get(String sourceToken, EntityType type, String id);
    
    public void delete(String sourceToken, EntityType type, String id);
    
    public void verify(String sourceToken, EntityType type, Object obj, Boolean returnOnlyId);
    
    public <T> Iterable<T> list(String sourceToken, EntityType type, BaseRequest request);

    public <T> Iterable<T> listPaged(String sourceToken, EntityType type, BaseRequest request);
    
    public void undelete(String sourceToken, EntityType type, String id);

    Object execute(String sourceToken, EntityType type, String operation);
}
