package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item { 
    @XmlElement(namespace = "http://www.freshbooks.com/api/")
    protected String name;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected String description;
    @XmlElement(name = "unit_cost", namespace = "http://www.freshbooks.com/api/", required = false)
    protected String unitCost;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected Integer quantity;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    protected String inventory;

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

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

}
