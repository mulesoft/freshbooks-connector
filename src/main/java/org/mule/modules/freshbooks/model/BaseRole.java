package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
    Client.class,
    Invoice.class
})

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseRole {

    @XmlElement(name = "first_name", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String firstName;
    @XmlElement(name = "last_name", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String lastName;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected String organization;
    @XmlElement(name = "p_street1", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String street1;
    @XmlElement(name = "p_street2", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String street2;
    @XmlElement(name = "p_city", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String city;
    @XmlElement(name = "p_state", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String state;
    @XmlElement(name = "p_country", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String country;
    @XmlElement(name = "p_code", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String code;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected String language;
    @XmlElement(name = "vat_name", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String vatName;
    @XmlElement(name = "vat_number", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String vatNumber;
    @XmlElements({
        @XmlElement(name = "contact",  namespace = "http://www.freshbooks.com/api/", type = Contact.class, required = false)
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
