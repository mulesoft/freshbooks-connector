package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InvoiceStatusEnum")
@XmlEnum
public enum LineTypeEnum {

        @XmlEnumValue("Item")
        ITEM("Item"),
        @XmlEnumValue("Time")
        TIME("Time");
        
        private final String value;

        LineTypeEnum(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static LineTypeEnum fromValue(String v) {
            for (LineTypeEnum c: LineTypeEnum.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }

}
