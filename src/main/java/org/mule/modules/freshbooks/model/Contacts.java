package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Contacts {
    @XmlElement(name = "contact", namespace = "http://www.freshbooks.com/api/")
    private List<Contact> contacts;
    
    public List<Contact> getContacts() {
        if(contacts == null) {
            contacts = new ArrayList<Contact>();
        }
        return contacts;
    }
}
