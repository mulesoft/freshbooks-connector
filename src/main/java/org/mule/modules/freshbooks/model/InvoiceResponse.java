package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class InvoiceResponse extends BaseResponse {
    
    @XmlElement(name = "invoice_id", nillable = true)
    private String invoiceId;
    @XmlElement(name = "invoice", required = false)
    private Invoice invoice;
    @XmlElement(name = "invoices", required = false)
    private Invoices invoices;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }
}
