/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {
    
    @XmlElement(name = "payment_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(name = "client_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String clientId;
    @XmlElement(name = "invoice_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String invoiceId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String date;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal amount;
    @XmlElement(name = "currency_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String currencyCode;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private PaymentTypes type;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String notes;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    @XmlElement(name = "from_credit", namespace = "http://www.freshbooks.com/api/", required = false)
    private Boolean fromCredit;
    
    public String getUpdated() {
        return updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public PaymentTypes getType() {
        return type;
    }

    public void setType(PaymentTypes type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getFromCredit() {
        return fromCredit;
    }

    public void setFromCredit(Boolean fromCredit) {
        this.fromCredit = fromCredit;
    }
}
