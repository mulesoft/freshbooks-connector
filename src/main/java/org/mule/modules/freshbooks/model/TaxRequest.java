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
public class TaxRequest extends BaseRequest {

    @XmlElement(name = "tax_id")
    private String taxId;
    @XmlElement(name = "tax")
    private Tax tax;

    public String getTaxId() {
        return taxId;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
