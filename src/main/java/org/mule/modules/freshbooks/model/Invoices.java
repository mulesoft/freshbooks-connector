package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Invoices extends Paged<Invoice> {
    @XmlElement(name="invoice")
    public ArrayList<Invoice> getInvoices() {
        return getContents();
    }
}
