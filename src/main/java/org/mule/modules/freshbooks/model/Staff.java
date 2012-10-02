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

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "staff")
@XmlAccessorType(XmlAccessType.FIELD)
public class Staff {
    
    @XmlElement(name = "staff_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String username;
    @XmlElement(name = "first_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String firstName;
    @XmlElement(name = "last_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String lastName;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String email;
    @XmlElement(name = "business_phone", namespace = "http://www.freshbooks.com/api/", required = false)
    private String businessPhone;
    @XmlElement(name = "mobile_phone", namespace = "http://www.freshbooks.com/api/", required = false)
    private String mobilePhone;
    @XmlElement(name = "number_of_logins", namespace = "http://www.freshbooks.com/api/", required = false)
    private String numberOfLogins;
    @XmlElement(name = "signup_date", namespace = "http://www.freshbooks.com/api/", required = false)
    private String signupDate;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String street1;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String street2;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String city;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String state;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String country;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String code;
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getNumberOfLogins() {
        return numberOfLogins;
    }

    public String getSignupDate() {
        return signupDate;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setNumberOfLogins(String numberOfLogins) {
        this.numberOfLogins = numberOfLogins;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
