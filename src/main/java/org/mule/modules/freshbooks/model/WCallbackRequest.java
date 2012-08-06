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

public class WCallbackRequest {
    private CallbackRequest callbackRequest;

    public WCallbackRequest() {

    }
    
    public WCallbackRequest(CallbackRequest callbackRequest) {
        this.callbackRequest = callbackRequest;
    }
    
    /**
     * @return the callbackRequest
     */
    public CallbackRequest getCallbackRequest() {
        return callbackRequest;
    }

    /**
     * @param callbackRequest the callbackRequest to set
     */
    public void setCallbackRequest(CallbackRequest callbackRequest) {
        this.callbackRequest = callbackRequest;
    }
    
}
