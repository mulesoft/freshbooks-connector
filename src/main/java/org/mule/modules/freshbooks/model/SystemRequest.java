/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class SystemRequest extends BaseRequest {
    
    @XmlElement(name = "system")
    private System system;

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

}
