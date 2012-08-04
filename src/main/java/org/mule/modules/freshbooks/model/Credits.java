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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Credits {
    @XmlElement(name = "credit", namespace = "http://www.freshbooks.com/api/")
    private List<Credit> credits;
    
    public List<Credit> getCredits() {
        if(credits == null) {
            credits = new ArrayList<Credit>();
        }
        return credits;
    }
}