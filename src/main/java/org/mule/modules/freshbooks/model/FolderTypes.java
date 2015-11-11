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

@XmlType(namespace = "FolderTypes", name = "FolderTypes")
@XmlEnum
public enum FolderTypes {
    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("archived")
    ARCHIVED("archived"),
    @XmlEnumValue("deleted")
    DELETED("deleted");

    private final String value;

    FolderTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FolderTypes fromValue(String v) {
        for (FolderTypes c : FolderTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
