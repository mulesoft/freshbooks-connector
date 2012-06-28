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
//    <date>2007-05-30</date>             <!-- Default value is today's date (Optional) -->  
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
}
