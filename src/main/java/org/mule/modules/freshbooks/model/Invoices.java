package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Invoices extends Paged<Invoice> {
    @XmlElement(name="invoice", namespace = "http://www.freshbooks.com/api/")
    public ArrayList<Invoice> getInvoices() {
        return getContents();
    }
}
