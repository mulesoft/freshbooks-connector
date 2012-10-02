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
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name="client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends BaseRole {

    @XmlElement(name = "client_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(name = "currency_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String currencyCode;
    @XmlElement(namespace = "http://www.freshbooks.com/api/")
    private String email;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String username;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String password;
    @XmlElement(name = "work_phone", namespace = "http://www.freshbooks.com/api/", required = false)
    private String workPhone;
    @XmlElement(name = "home_phone", namespace = "http://www.freshbooks.com/api/", required = false)
    private String homePhone;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String mobile;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String fax;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String notes;
    @XmlElement(name = "s_street1", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryStreet1;
    @XmlElement(name = "s_street2", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryStreet2;
    @XmlElement(name = "s_city", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryCity;
    @XmlElement(name = "s_state", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryState;
    @XmlElement(name = "s_country", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryCountry;
    @XmlElement(name = "s_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String secondaryCode;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Credit credit;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Credits credits;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    
    public String getUpdated() {
        return updated;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if(credits == null)
            credits = new Credits();
        return credits.getCredits();
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Credit getCredit() {
        return credit;
    }
    
    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }
    
    public void setCredits(List<Credit> credits) {
        if(this.credits == null)
            this.credits = new Credits();
        this.credits.setCredits(credits);
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
