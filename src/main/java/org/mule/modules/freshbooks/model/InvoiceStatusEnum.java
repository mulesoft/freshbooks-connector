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
        @XmlEnumValue("viewed")
        VIEWED("viewed");
        
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
