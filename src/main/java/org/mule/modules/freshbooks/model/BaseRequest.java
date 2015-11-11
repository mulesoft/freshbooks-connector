/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
        CategoryRequest.class,
        CallbackRequest.class,
        ClientRequest.class,
        InvoiceRequest.class,
        ItemRequest.class,
        PaymentRequest.class })
@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(name = "request")
public abstract class BaseRequest {

    @XmlAttribute
    private String method;
    @XmlAttribute(name = "source-token", required = false)
    private String sourceToken;
    @XmlElement(name = "date_from")
    private String dateFrom;
    @XmlElement(name = "date_to")
    private String dateTo;
    @XmlElement(name = "updated_from")
    private String updatedFrom;
    @XmlElement(name = "updated_to")
    private String updatedTo;
    @XmlElement
    private Integer page;
    @XmlElement(name = "per_page")
    private Integer perPage;
    @XmlElement
    private FolderTypes folder;

    // <date_from>2007-01-01</date_from> <!-- Return payments dated after this arg (Optional) -->
    // <date_to>2007-04-01</date_to> <!-- Return payments dated before this arg (Optional) -->
    // <updated_from>2007-01-01</updated_from> <!-- Return payments modified after this arg (Optional) -->
    // <updated_to>2007-04-01</updated_to> <!-- Return payments modified before this arg (Optional) -->

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getUpdatedFrom() {
        return updatedFrom;
    }

    public void setUpdatedFrom(String updateFrom) {
        this.updatedFrom = updateFrom;
    }

    public String getUpdatedTo() {
        return updatedTo;
    }

    public void setUpdatedTo(String updateTo) {
        this.updatedTo = updateTo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public FolderTypes getFolder() {
        return folder;
    }

    public void setFolder(FolderTypes folder) {
        this.folder = folder;
    }

    public String getSourceToken() {
        return sourceToken;
    }

    public void setSourceToken(String sourceToken) {
        this.sourceToken = sourceToken;
    }
}
