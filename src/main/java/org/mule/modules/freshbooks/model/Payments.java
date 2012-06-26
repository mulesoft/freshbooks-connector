package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Payments extends Paged<Payment> {
    @XmlElement(name = "payment", namespace = "http://www.freshbooks.com/api/")
    public ArrayList<Payment> getPayments() {
        return getContents();
    }
}
