/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlElement(name = "item_id", namespace = "http://www.freshbooks.com/api/")
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/")
    private String name;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String description;
    @XmlElement(name = "unit_cost", namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal unitCost;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer quantity;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer inventory;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String updated;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private FolderTypes folder;
    
    public String getUpdated() {
        return updated;
    }
    
    public FolderTypes getFolder() {
        return folder;
    }
    
    public void setFolder(FolderTypes folder) {
        this.folder = folder;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

}
