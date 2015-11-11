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

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address extends BaseRole {

    @XmlElement(name = "street1", namespace = "http://www.freshbooks.com/api/", required = false)
    private String street1;
    @XmlElement(name = "street2", namespace = "http://www.freshbooks.com/api/", required = false)
    private String street2;
    @XmlElement(name = "city", namespace = "http://www.freshbooks.com/api/", required = false)
    private String city;
    @XmlElement(name = "province", namespace = "http://www.freshbooks.com/api/", required = false)
    private String province;
    @XmlElement(name = "country", namespace = "http://www.freshbooks.com/api/", required = false)
    private String country;
    @XmlElement(name = "postal_code", namespace = "http://www.freshbooks.com/api/", required = false)
    private String postalCode;

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
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

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
