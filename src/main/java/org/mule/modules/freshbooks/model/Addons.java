/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Addons extends Paged<Addon> {

    @XmlElement(name = "addon", namespace = "http://www.freshbooks.com/api/")
    public ArrayList<Addon> getAddons() {
        return getContents();
    }
}
