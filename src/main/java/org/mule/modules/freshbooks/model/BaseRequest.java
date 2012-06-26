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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
    CategoryRequest.class,
    CallbackRequest.class,
    ClientRequest.class,
    InvoiceRequest.class,
    ItemRequest.class,
    PaymentRequest.class
})

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "request")
public abstract class BaseRequest {
    
    @XmlAttribute
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
