/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks.model;

public class WClientRequest {
    private ClientRequest clientRequest;

    public WClientRequest() {
        
    }
    
    public WClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }
    
    /**
     * @return the clientRequest
     */
    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    /**
     * @param clientRequest the clientRequest to set
     */
    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }
    
    
}
