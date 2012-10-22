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

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "addon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Addon {
    
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String name;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String author;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String type;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String price;
    @XmlElement(name = "logo_image", namespace = "http://www.freshbooks.com/api/", required = false)
    private String logoImage;
    @XmlElement(name = "setup_url", namespace = "http://www.freshbooks.com/api/", required = false)
    private String setupUrl;
    @XmlElement(name = "eula_uri", namespace = "http://www.freshbooks.com/api/", required = false)
    private String eulaUri;
    @XmlElement(name = "contact_email", namespace = "http://www.freshbooks.com/api/", required = false)
    private String contactEmail;
    @XmlElement(name = "consumer_key", namespace = "http://www.freshbooks.com/api/", required = false)
    private String consumerKey;
    @XmlElement(name = "trial_days", namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer trialDays;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getType() {
        return type;
    }
    public String getPrice() {
        return price;
    }
    public String getLogoImage() {
        return logoImage;
    }
    public String getSetupUrl() {
        return setupUrl;
    }
    public String getEulaUri() {
        return eulaUri;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public String getConsumerKey() {
        return consumerKey;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
    public void setSetupUrl(String setupUrl) {
        this.setupUrl = setupUrl;
    }
    public void setEulaUri(String eulaUri) {
        this.eulaUri = eulaUri;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }
    public Integer getTrialDays() {
        return trialDays;
    }
    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

}
