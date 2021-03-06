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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://www.freshbooks.com/api/", name = "contact")
public class Contact {

    @XmlElement(name = "contact_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;

    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String username;

    @XmlElement(name = "first_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String firstName;

    @XmlElement(name = "last_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String lastName;

    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String email;

    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String phone1;

    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String phone2;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone1
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * @param phone1
     *            the phone1 to set
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * @return the phone2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * @param phone2
     *            the phone2 to set
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
