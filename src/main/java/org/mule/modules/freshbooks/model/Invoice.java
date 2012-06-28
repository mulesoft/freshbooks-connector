package org.mule.modules.freshbooks.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name="invoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice extends BaseRole {
    
    @XmlElement(name = "invoice_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(name = "client_id", namespace = "http://www.freshbooks.com/api/")
    private String clientId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String number;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal amount;
    @XmlElement(name = "amount_outstanding", namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal amountOutstanding;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private InvoiceStatusEnum status;
//    <!-- If not supplied, defaults to today's date (Optional) -->  
//         @XmlElement(namespace = "http://www.freshbooks.com/api/")
//         @XmlSchemaType(name="date")
//         public XMLGregorianCalendar date;
//         <date>2007-06-23</date> 
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String date;
    @XmlElement(name = "po_number", namespace = "http://www.freshbooks.com/api/", required = false)
    private String poNumber;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal discount;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String notes;
    @XmlElement(name = "currency_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String currencyCode;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String terms;
    @XmlElement(name = "return_url", namespace = "http://www.freshbooks.com/api/", required = false)
    private String returnUri;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Lines lines;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private FolderTypes folder;
    @XmlElement(name = "recurring_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String recurringId;
    @XmlElement(name = "staff_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String staffId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    
    /*    <invoice>        
    <url deprecated="true">https://2ndsite.freshbooks.com/view/St2gThi6rA2t7RQ</url> <!-- (Read-only) -->  
    <auth_url deprecated="true">https://2ndsite.freshbooks.com/invoices/344</auth_url> <!-- (Read-only) -->  
    <links>  
      <client_view>https://2ndsite.freshbooks.com/view/St2gThi6rA2t7RQ</client_view> <!-- (Read-only) -->  
      <view>https://2ndsite.freshbooks.com/invoices/344</view> <!-- (Read-only) -->  
      <edit>https://2ndsite.freshbooks.com/invoices/344/edit</edit> <!-- (Read-only) -->  
    </links>  
  </invoice>  */
    public String getRecurringId() {
        return recurringId;
    }
    
    public String getUpdated() {
        return updated;
    }
    
    public String getStaffId() {
        return staffId;
    }
    
    public void setFolder(String staffId) {
        this.staffId = staffId;
    }
    
    public FolderTypes getFolder() {
        return folder;
    }
    
    public void setFolder(FolderTypes folder) {
        this.folder = folder;
    }
    
    public BigDecimal getAmountOutstanding() {
        return amountOutstanding;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
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
        if(lines == null)
            lines = new Lines();
        return lines.getLines();
    }
}
