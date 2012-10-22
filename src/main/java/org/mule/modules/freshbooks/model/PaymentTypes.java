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

@XmlType(namespace="PaymentTypes", name="PaymentTypes")
@XmlEnum
public enum PaymentTypes {
    @XmlEnumValue("Cash")
    CASH("Cash"),
    @XmlEnumValue("Check")
    CHECK("Check"),
    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("Credit Card")
    CREDIT_CARD("Credit Card"),
    @XmlEnumValue("Bank Transfer")
    BANK_TRANSFER("Bank Transfer"),
    @XmlEnumValue("Debit")
    DEBIT("Debit"),
    @XmlEnumValue("PayPal")
    PAYPAL("PayPal"),
    @XmlEnumValue("2Checkout")
    CHECKOUT("2Checkout"),
    @XmlEnumValue("VISA")
    VISA("VISA"),
    @XmlEnumValue("MASTERCARD")
    MASTERCARD("MASTERCARD"),
    @XmlEnumValue("DISCOVER")
    DISCOVER("DISCOVER"),
    @XmlEnumValue("NOVA")
    NOVA("NOVA"),
    @XmlEnumValue("AMEX")
    AMEX("AMEX"),
    @XmlEnumValue("DINERS")
    DINERS("DINERS"),
    @XmlEnumValue("EUROCARD")
    EUROCARD("EUROCARD"),
    @XmlEnumValue("JCB")
    JCB("JCB"),
    @XmlEnumValue("ACH")
    ACH("ACH");
    
    private final String value;
    
    PaymentTypes(String v) {
        value = v;
    }
    
    public String value() {
        return value;
    }
    
    public static PaymentTypes fromValue(String v) {
        for (PaymentTypes c: PaymentTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
