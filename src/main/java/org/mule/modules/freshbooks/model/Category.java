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

@XmlType(namespace = "http://www.freshbooks.com/api/", name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
    @XmlElement(namespace = "http://www.freshbooks.com/api/")
    private String name;
    @XmlElement(name = "category_id", namespace = "http://www.freshbooks.com/api/")
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    
    public String getUpdated() {
        return updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setUpdated(String updated) {
        this.updated = updated;
    }
    
}
