/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(namespace="InvoiceStatusEnum", name="InvoiceStatusEnum")
@XmlEnum
public enum InvoiceStatusEnum {

        @XmlEnumValue("draft")
        DRAFT("draft"),
        @XmlEnumValue("sent")
        SENT("sent"),
        @XmlEnumValue("paid")
        PAID("paid"),
        @XmlEnumValue("viewed")
        VIEWED("viewed"),
        @XmlEnumValue("disputed")
        DISPUTED("disputed"),
        @XmlEnumValue("partial")
        PARTIAL("partial"),
        @XmlEnumValue("pending")
        PENDING("pending"),
        @XmlEnumValue("auto-paid")
        AUTOPAID("auto-paid"),
        @XmlEnumValue("retry")
        RETRY("retry"),
        @XmlEnumValue("failed")
        FAILED("failed"),
        @XmlEnumValue("declined")
        DECLINED("declined");
        
        private final String value;

        InvoiceStatusEnum(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static InvoiceStatusEnum fromValue(String v) {
            for (InvoiceStatusEnum c: InvoiceStatusEnum.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }
}
