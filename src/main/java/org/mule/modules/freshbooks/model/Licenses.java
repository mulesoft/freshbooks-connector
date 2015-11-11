/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Licenses {

    @XmlElement(name = "license", namespace = "http://www.freshbooks.com/api/")
    private List<License> licenses;

    public List<License> getLicenses() {
        if (licenses == null) {
            licenses = new ArrayList<License>();
        }
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }
}
