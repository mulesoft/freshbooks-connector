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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.freshbooks.com/api/", name = "license")
@XmlAccessorType(XmlAccessType.FIELD)
public class License {
    
    @XmlElement(name = "license_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String id;
    @XmlElement(name = "addon_id", namespace = "http://www.freshbooks.com/api/", required = true)
    private String addonId;
    @XmlElement(name = "staff_id", namespace = "http://www.freshbooks.com/api/", required = false)
    private String staffId;
    @XmlElement(name = "trial", namespace = "http://www.freshbooks.com/api/", required = false)
    private String trial;
    @XmlElement(name = "status", namespace = "http://www.freshbooks.com/api/", required = false)
    private String status;
    @XmlElement(name = "remaining_trial_days", namespace = "http://www.freshbooks.com/api/", required = false)
    private Integer remainingTrialDays;

    public String getId() {
        return id;
    }
    public String getAddonId() {
        return addonId;
    }
    public String getStaffId() {
        return staffId;
    }
    public String getTrial() {
        return trial;
    }
    public String getStatus() {
        return status;
    }
    public Integer getRemainingTrialDays() {
        return remainingTrialDays;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAddonId(String addonId) {
        this.addonId = addonId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public void setTrial(String trial) {
        this.trial = trial;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setRemainingTrialDays(Integer remainingTrialDays) {
        this.remainingTrialDays = remainingTrialDays;
    }
    
}
