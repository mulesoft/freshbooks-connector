/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

public class WItemRequest {
    private ItemRequest itemRequest;

    public WItemRequest() {
        
    }
    
    public WItemRequest(ItemRequest itemRequest) {
        this.itemRequest = itemRequest;
    }
    /**
     * @return the itemRequest
     */
    public ItemRequest getItemRequest() {
        return itemRequest;
    }

    /**
     * @param itemRequest the itemRequest to set
     */
    public void setItemRequest(ItemRequest itemRequest) {
        this.itemRequest = itemRequest;
    }
    
    
}
