package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public abstract class BaseRole {

    @XmlElement(name = "first_name", required = false)
    protected String firstName;
    @XmlElement(name = "last_name", required = false)
    protected String lastName;
    @XmlElement(name = "organization", required = false)
    protected String organization;
    @XmlElement(name = "p_street1", required = false)
    protected String street1;
    @XmlElement(name = "p_street2", required = false)
    protected String street2;
    @XmlElement(name = "p_city", required = false)
    protected String city;
    @XmlElement(name = "p_state", required = false)
    protected String state;
    @XmlElement(name = "p_country", required = false)
    protected String country;
    @XmlElement(name = "p_code", required = false)
    protected String code;
    @XmlElement(name = "language", required = false)
    protected String language;
    @XmlElement(name = "vat_name", required = false)
    protected String vatName;
    @XmlElement(name = "vat_number", required = false)
    protected String vatNumber;
    @XmlElements({
        @XmlElement(name = "contact", type = Contact.class, required = false)
    })
    protected List<Contact> contacts;
    
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
    
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        if(contacts == null) {
            contacts = new ArrayList<Contact>();
        }
        return contacts;
    }
}
