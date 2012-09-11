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

import java.io.Serializable;

import org.mule.api.store.ObjectAlreadyExistsException;
import org.mule.api.store.ObjectDoesNotExistException;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;

@SuppressWarnings("rawtypes")
public class ObjectStoreHelper {

    private ObjectStore objectStore;

    public ObjectStoreHelper() {
        
    }

    public ObjectStoreHelper(ObjectStore objectStore) {
        setObjectStore(objectStore);
    }
    
    public Object retrieve(String key) 
            throws ObjectStoreException {
        Object ret = null;
        try {
            ret = objectStore.retrieve(key);
        } catch (ObjectDoesNotExistException ose) {
            throw ose;
        }

        if (ret == null) 
        {
            throw new ObjectDoesNotExistException();
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    public void store(String key, Serializable value, boolean overwrite) 
            throws ObjectStoreException {
        try {
            objectStore.store(key, value);
        } catch (ObjectAlreadyExistsException e) {
            if (overwrite) {
                objectStore.remove(key);
                objectStore.store(key, value);
            } else {
                throw e;
            }
        }
    }

    public ObjectStore getObjectStore() {
        return objectStore;
    }


    public void setObjectStore(ObjectStore objectStore) {
        this.objectStore = objectStore;
    }
    
}
