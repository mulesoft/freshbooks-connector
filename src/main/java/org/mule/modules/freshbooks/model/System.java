/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "system")
@XmlAccessorType(XmlAccessType.FIELD)
public class System {
    
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String name;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String email;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String username;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String password;
    @XmlElement(name = "first_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String firstName;
    @XmlElement(name = "last_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String lastName;
    @XmlElement(name = "work_phone", namespace = "http://www.freshbooks.com/api/", required = false)
    private String workPhone;
    @XmlElement(name = "profession", namespace = "http://www.freshbooks.com/api/", required = false)
    private String profession;
    @XmlElement(name = "currency_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String currencyCode;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Address address;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Notifications notifications;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String terms;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String domain;
    @XmlElement(name = "access_token", namespace = "http://www.freshbooks.com/api/", required = false)
    private String accessToken;
    @XmlElement(name = "access_token_secret", namespace = "http://www.freshbooks.com/api/", required = false)
    private String accessTokenSecret;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public String getProfession() {
        return profession;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public Address getAddress() {
        return address;
    }
    public Notifications getNotifications() {
        return notifications;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }
    public String getTerms() {
        return terms;
    }
    public void setTerms(String terms) {
        this.terms = terms;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
}
