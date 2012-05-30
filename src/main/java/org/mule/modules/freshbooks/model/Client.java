/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends BaseRole {

    @XmlElement(name = "client_id", required = false)
    protected String id;
    @XmlElement(name = "currency_code", required = false)
    protected String currencyCode;
    @XmlElement(name = "email")
    protected String email;
    @XmlElement(name = "username", required = false)
    protected String username;
    @XmlElement(name = "password", required = false)
    protected String password;
    @XmlElement(name = "work_phone", required = false)
    protected String workPhone;
    @XmlElement(name = "home_phone", required = false)
    protected String homePhone;
    @XmlElement(name = "mobile", required = false)
    protected String mobile;
    @XmlElement(name = "fax", required = false)
    protected String fax;
    @XmlElement(name = "notes", required = false)
    protected String notes;
    @XmlElement(name = "s_street1", required = false)
    protected String secondaryStreet1;
    @XmlElement(name = "s_street2", required = false)
    protected String secondaryStreet2;
    @XmlElement(name = "s_city", required = false)
    protected String secondaryCity;
    @XmlElement(name = "s_state", required = false)
    protected String secondaryState;
    @XmlElement(name = "s_country", required = false)
    protected String secondaryCountry;
    @XmlElement(name = "s_code", required = false)
    protected String secondaryCode;
    @XmlElements({
            @XmlElement(name = "credit", type = Credit.class, required = false)
    })
    protected List<Credit> credits;

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
        if(credits == null) {
            credits = new ArrayList<Credit>();
        }
        return credits;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
