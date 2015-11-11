/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.automation.unit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.modules.freshbooks.automation.util.RequestAndResponseUtil;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.ClientRequest;
import org.mule.modules.freshbooks.model.FolderTypes;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.modules.freshbooks.model.InvoiceRequest;
import org.mule.modules.freshbooks.model.InvoiceStatusEnum;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class InvoiceTest extends RequestAndResponseUtil {

    private static Client client;
    private static InvoiceRequest request;

    @BeforeClass
    public void setUp() {

        request = new InvoiceRequest();
        request.setStatus(InvoiceStatusEnum.DRAFT);
        request.setClientId("3");
        request.setRecurringId("10");
        request.setNumber("FB00004");
        request.setDateFrom("2007-01-01");
        request.setDateTo("2007-04-01");
        request.setUpdatedFrom("2007-01-01 00:00:00");
        request.setUpdatedTo("2007-01-02 00:00:00");
        request.setPage(1);
        request.setPerPage(10);
        request.setFolder(FolderTypes.ACTIVE);
        request.setMethod("invoice.list");

    }

    @Test
    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/invoice.get.xml");
        Invoice inv = response.getInvoice();
        assertThat(inv.getId(), is("344"));
        assertThat(inv.getContacts().get(0).getId(), is("0"));
        assertThat(inv.getFolder(), is(FolderTypes.ACTIVE));
        assertThat(inv.getLines().get(0).getAmount(), is(BigDecimal.valueOf(40)));
    }

    @Test
    public void testListRequest() throws JAXBException, IOException, SAXException {
        assertRequest("model/request/invoice.list.xml", request);
    }

    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/invoice.list.xml");
        assertThat(response.getInvoices().size(), is(1));
        Invoice inv = response.getInvoices().get(0);
        assertThat(inv.getId(), is("344"));
        assertThat(inv.getContacts().get(0).getId(), is("0"));
        assertThat(inv.getFolder(), is(FolderTypes.ACTIVE));
        assertThat(inv.getLines().get(0).getAmount(), is(BigDecimal.valueOf(40)));

    }
}
