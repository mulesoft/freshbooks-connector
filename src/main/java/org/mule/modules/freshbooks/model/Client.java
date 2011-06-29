package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @XmlElement(name = "client_id", required = false)
    Long id;

    @XmlElement(name = "first_name")
    String firstName;

    @XmlElement(name = "last_name")
    String lastName;

    @XmlElement(name = "organization")
    String organization;

    @XmlElement(name = "currency_code", required = false)
    String currencyCode;

    @XmlElement(name = "email")
    String email;
    @XmlElement(name = "username", required = false)
    String username;
    @XmlElement(name = "password", required = false)
    String password;

    @XmlElement(name = "work_phone", required = false)
    String workPhone;

    @XmlElement(name = "home_phone", required = false)
    String homePhone;

    @XmlElement(name = "mobile", required = false)
    String mobile;
    @XmlElement(name = "fax", required = false)
    String fax;
    @XmlElement(name = "notes", required = false)
    String notes;

    @XmlElement(name = "p_street1", required = false)
    String street1;
    @XmlElement(name = "p_street2", required = false)
    String street2;
    @XmlElement(name = "p_city", required = false)
    String city;
    @XmlElement(name = "p_state", required = false)
    String state;
    @XmlElement(name = "p_country", required = false)
    String country;
    @XmlElement(name = "p_code", required = false)
    String code;

    @XmlElement(name = "s_street1", required = false)
    String secondaryStreet1;
    @XmlElement(name = "s_street2", required = false)
    String secondaryStreet2;
    @XmlElement(name = "s_city", required = false)
    String secondaryCity;
    @XmlElement(name = "s_state", required = false)
    String secondaryState;
    @XmlElement(name = "s_country", required = false)
    String secondaryCountry;
    @XmlElement(name = "s_code", required = false)
    String secondaryCode;
    @XmlElement(name = "language", required = false)
    String language;
    @XmlElement(name = "vat_name", required = false)
    String vatName;
    @XmlElement(name = "vat_number", required = false)
    String vatNumber;

    @XmlElements({
            @XmlElement(name = "credit", type = Credit.class, required = false)
    })
    List<Credit> credits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getSecondaryStreet1() {
        return secondaryStreet1;
    }

    public void setSecondaryStreet1(String secondaryStreet1) {
        this.secondaryStreet1 = secondaryStreet1;
    }

    public String getSecondaryStreet2() {
        return secondaryStreet2;
    }

    public void setSecondaryStreet2(String secondaryStreet2) {
        this.secondaryStreet2 = secondaryStreet2;
    }

    public String getSecondaryCity() {
        return secondaryCity;
    }

    public void setSecondaryCity(String secondaryCity) {
        this.secondaryCity = secondaryCity;
    }

    public String getSecondaryState() {
        return secondaryState;
    }

    public void setSecondaryState(String secondaryState) {
        this.secondaryState = secondaryState;
    }

    public String getSecondaryCountry() {
        return secondaryCountry;
    }

    public void setSecondaryCountry(String secondaryCountry) {
        this.secondaryCountry = secondaryCountry;
    }

    public String getSecondaryCode() {
        return secondaryCode;
    }

    public void setSecondaryCode(String secondaryCode) {
        this.secondaryCode = secondaryCode;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
}
