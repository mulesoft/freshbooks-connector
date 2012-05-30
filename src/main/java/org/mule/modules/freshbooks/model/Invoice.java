package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice extends BaseRole {
    
    @XmlElement(name = "invoice_id")
    protected String id;
    @XmlElement(name = "client_id")
    protected String clientId;
    @XmlElement(name = "number", required = false)
    protected String number;
    @XmlElement(name = "status", required = false)
    protected InvoiceStatusEnum status;
//    <!-- If not supplied, defaults to today's date (Optional) -->  
//TODO    <date>2007-06-23</date> 
    @XmlElement(name = "date", required = false)
    protected String date;
    @XmlElement(name = "po_number", required = false)
    protected String poNumber;
//  <!-- Percent discount (Optional) -->  
//  <discount>10</discount>  
    @XmlElement(name = "discount", required = false)
    protected String discount;
    @XmlElement(name = "notes", required = false)
    protected String notes;

//    <!-- Currency Code, defaults to your base currency (Optional) -->  
//    <currency_code>CAD</currency_code>
    @XmlElement(name = "currency_code", required = false)
    protected String currencyCode;
//    <!-- Terms (Optional) -->  
//    <terms>Payment due in 30 days.</terms>
    @XmlElement(name = "terms", required = false)
    protected String terms;
    
//  <!-- Return URI (Optional) -->  
//  <return_uri>http://example.com/account</return_uri> 
    @XmlElement(name = "return_url", required = false)
    protected String returnUri;
    @XmlElements({
        @XmlElement(name = "line", type = Line.class, required = false)
    })
    protected List<Line> lines;
    
    public InvoiceStatusEnum getStatus() {
        if (status == null) {
            return InvoiceStatusEnum.DRAFT;
        } else {
            return status;
        }
    }

    public void setStatus(InvoiceStatusEnum status) {
        this.status = status;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getReturnUri() {
        return returnUri;
    }

    public void setReturnUri(String returnUri) {
        this.returnUri = returnUri;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public List<Line> getLines() {
        if(lines == null) {
            lines = new ArrayList<Line>();
        }
        return lines;
    }
}
