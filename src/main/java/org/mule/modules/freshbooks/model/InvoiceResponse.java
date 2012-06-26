package org.mule.modules.freshbooks.model;


public class InvoiceResponse extends BaseResponse {
    
    private String invoiceId;
    private Invoice invoice;
    private Invoices invoices;

    public InvoiceResponse(Response response) {
        initBaseResponseFields(response);
        invoiceId = response.getInvoiceId();
        invoice = response.getInvoice();
        invoices = response.getInvoices();
    }
    
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
