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

public class WInvoiceRequest {
    private InvoiceRequest invoiceRequest;
    
    public WInvoiceRequest() {
        
    }
    
    public WInvoiceRequest(InvoiceRequest invoiceRequest) {
        this.invoiceRequest = invoiceRequest;
    }

    /**
     * @return the invoiceRequest
     */
    public InvoiceRequest getInvoiceRequest() {
        return invoiceRequest;
    }

    /**
     * @param invoiceRequest the invoiceRequest to set
     */
    public void setInvoiceRequest(InvoiceRequest invoiceRequest) {
        this.invoiceRequest = invoiceRequest;
    }
    
    
}
