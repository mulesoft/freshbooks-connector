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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({
    CategoryResponse.class,
    CallbackResponse.class,
    ClientResponse.class,
    InvoiceResponse.class,
    ItemResponse.class,
    PaymentResponse.class
})

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", namespace = "http://www.freshbooks.com/api/")
public abstract class BaseResponse {

    @XmlAttribute
    private String status;
    @XmlElement(name = "error", required = false)
    private String error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
