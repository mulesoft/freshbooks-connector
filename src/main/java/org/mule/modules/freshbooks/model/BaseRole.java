/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
    Client.class,
    Invoice.class
})

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseRole {

    @XmlElement(name = "first_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String firstName;
    @XmlElement(name = "last_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String lastName;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String organization;
    @XmlElement(name = "p_street1", namespace = "http://www.freshbooks.com/api/", required = false)
    private String p_street1;
    @XmlElement(name = "p_street2", namespace = "http://www.freshbooks.com/api/", required = false)
    private String p_street2;
    @XmlElement(name = "p_city", namespace = "http://www.freshbooks.com/api/", required = false)
    private String p_city;
    @XmlElement(name = "p_state", namespace = "http://www.freshbooks.com/api/", required = false)
    private String state;
    @XmlElement(name = "p_country", namespace = "http://www.freshbooks.com/api/", required = false)
    private String p_country;
    @XmlElement(name = "p_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String code;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String language;
    @XmlElement(name = "vat_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String vatName;
    @XmlElement(name = "vat_number", namespace = "http://www.freshbooks.com/api/", required = false)
    private String vatNumber;
    
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Contacts contacts;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public String getP_street1() {
        return p_street1;
    }

    
    public void setP_street1(String p_street1) {
        this.p_street1 = p_street1;
    }

    
    public String getP_street2() {
        return p_street2;
    }

    
    public void setP_street2(String p_street2) {
        this.p_street2 = p_street2;
    }

    
    public String getP_city() {
        return p_city;
    }

    
    public void setP_city(String p_city) {
        this.p_city = p_city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getP_country() {
        return p_country;
    }

    public void setP_country(String p_country) {
        this.p_country = p_country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String getVatName() {
        return vatName;
    }

    public void setVatName(String vatName) {
        this.vatName = vatName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }
    
    public List<Contact> getContacts() {
        if(contacts == null)
            contacts = new Contacts();
        return contacts.getContacts();
    }
    
    public void setContacts(List<Contact> contacts) {
        if(this.contacts == null)
            this.contacts = new Contacts();
        this.contacts.setContacts(contacts);
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
