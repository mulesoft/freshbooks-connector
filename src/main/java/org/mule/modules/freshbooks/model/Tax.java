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

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "tax")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tax {

    @XmlElement(name = "tax_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = true)
    private String name;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String rate;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String number;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String compound;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }

    public String getNumber() {
        return number;
    }

    public String getCompound() {
        return compound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
