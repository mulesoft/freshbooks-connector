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

@XmlType(namespace = "http://www.freshbooks.com/api/", name="notifications")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notifications extends BaseRole {

    @XmlElement(name = "late_payment_reminder1", namespace = "http://www.freshbooks.com/api/", required = false)
    private String latePaymentReminder1;
    @XmlElement(name = "late_payment_reminder2", namespace = "http://www.freshbooks.com/api/", required = false)
    private String latePaymentReminder2;
    @XmlElement(name = "late_payment_reminder3", namespace = "http://www.freshbooks.com/api/", required = false)
    private String latePaymentReminder3;
    
    public String getLatePaymentReminder1() {
        return latePaymentReminder1;
    }
    public String getLatePaymentReminder2() {
        return latePaymentReminder2;
    }
    public String getLatePaymentReminder3() {
        return latePaymentReminder3;
    }
    public void setLatePaymentReminder1(String latePaymentReminder1) {
        this.latePaymentReminder1 = latePaymentReminder1;
    }
    public void setLatePaymentReminder2(String latePaymentReminder2) {
        this.latePaymentReminder2 = latePaymentReminder2;
    }
    public void setLatePaymentReminder3(String latePaymentReminder3) {
        this.latePaymentReminder3 = latePaymentReminder3;
    }
}
