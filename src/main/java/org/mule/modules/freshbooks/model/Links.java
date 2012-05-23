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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Links {

    @XmlElement( name =  "view")
    private String view;
    @XmlElement( name =  "client_view")
    private String clientView;
    @XmlElement( name =  "edit")
    private String edit;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getClientView() {
        return clientView;
    }

    public void setClientView(String clientView) {
        this.clientView = clientView;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
}
