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
    
    public String create(EntityType type, Object obj);
    
    public void update(EntityType type, Object obj);
    
    public Object get(EntityType type, String id);
    
    public void delete(EntityType type, String id);
    
    public <T> Iterable<T> list(EntityType type, BaseRequest request);

    public <T> Iterable<T> listPaged(EntityType type, BaseRequest request);
    
    public void undelete(EntityType type, String id);
}
