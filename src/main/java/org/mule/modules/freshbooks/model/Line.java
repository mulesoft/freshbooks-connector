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

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Line {

    @XmlElement(name = "line_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal amount;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String name;    
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private String description;
    @XmlElement(name = "unit_cost", namespace = "http://www.freshbooks.com/api/", required = false)
    private Double unitCost;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer quantity;
    @XmlElement(name = "tax1_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String tax1Name;
    @XmlElement(name = "tax2_name", namespace = "http://www.freshbooks.com/api/", required = false)
    private String tax2Name;
    @XmlElement(name = "tax1_percent", namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal tax1Percent;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private BigDecimal tax2Percent;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private LineTypeEnum type;
    
    public String getId() {
        return id;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public LineTypeEnum getType() {
        if(type == null)
            return LineTypeEnum.ITEM;
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(LineTypeEnum type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitCost
     */
    public Double getUnitCost() {
        return unitCost;
    }

    /**
     * @param unitCost the unitCost to set
     */
    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the tax1Name
     */
    public String getTax1Name() {
        return tax1Name;
    }

    /**
     * @param tax1Name the tax1Name to set
     */
    public void setTax1Name(String tax1Name) {
        this.tax1Name = tax1Name;
    }

    /**
     * @return the tax2Name
     */
    public String getTax2Name() {
        return tax2Name;
    }

    /**
     * @param tax2Name the tax2Name to set
     */
    public void setTax2Name(String tax2Name) {
        this.tax2Name = tax2Name;
    }

    /**
     * @return the tax1Percent
     */
    public BigDecimal getTax1Percent() {
        return tax1Percent;
    }

    /**
     * @param tax1Percent the tax1Percent to set
     */
    public void setTax1Percent(BigDecimal tax1Percent) {
        this.tax1Percent = tax1Percent;
    }

    /**
     * @return the tax2Percent
     */
    public BigDecimal getTax2Percent() {
        return tax2Percent;
    }

    /**
     * @param tax2Percent the tax2Percent to set
     */
    public void setTax2Percent(BigDecimal tax2Percent) {
        this.tax2Percent = tax2Percent;
    }
}
