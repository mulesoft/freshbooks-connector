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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.store.ListableObjectStore;
import org.mule.api.store.ObjectStoreException;


/**
*   
*   Object Store implementation for Freshbooks connector
*
*   @author Mulesoft Inc.
*
*/
public class FreshBooksObjectStore implements ListableObjectStore<Serializable> {

    private Map<Serializable, Serializable> values = new LinkedHashMap<Serializable, Serializable>();

    @Override
    public boolean contains(Serializable key) throws ObjectStoreException {
        return this.values.containsKey(key);
    }

    @Override
    public void store(Serializable key, Serializable value)
            throws ObjectStoreException {
        this.values.put(key, value);

    }

    @Override
    public Serializable retrieve(Serializable key) throws ObjectStoreException {
        return this.values.get(key);
    }

    @Override
    public Serializable remove(Serializable key) throws ObjectStoreException {
        Serializable value = this.values.get(key);
        if (value != null) {
            this.values.remove(key);
        }
        return value;
    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    @Override
    public void open() throws ObjectStoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() throws ObjectStoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Serializable> allKeys() throws ObjectStoreException {
        return new ArrayList<Serializable>(values.keySet());
    }
}
