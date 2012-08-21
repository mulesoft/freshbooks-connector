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

public class WSessionRequest {
    private SessionRequest sessionRequest;

    public WSessionRequest() {
        
    }
    
    public WSessionRequest(SessionRequest sessionRequest) {
        this.setSessionRequest(sessionRequest);
    }

    public SessionRequest getSessionRequest() {
        return sessionRequest;
    }

    public void setSessionRequest(SessionRequest sessionRequest) {
        this.sessionRequest = sessionRequest;
    }

}
