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

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

public class InvoiceTest extends RequestAndResponseTest {
    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/invoice.get.xml");

        Invoice inv = response.getInvoice();
        
        assertEquals("344", inv.getId());
        assertEquals("0", inv.getContacts().get(0).getId());
        assertEquals(FolderTypes.ACTIVE, inv.getFolder());
        assertEquals(BigDecimal.valueOf(40), inv.getLines().get(0).getAmount());
    }
    
    public void testListRequest() throws JAXBException, IOException, SAXException {
        InvoiceRequest req = new InvoiceRequest();
        req.setStatus(InvoiceStatusEnum.DRAFT);
        req.setClientId("3");  
        req.setRecurringId("10");
        req.setNumber("FB00004");
        req.setDateFrom("2007-01-01");
        req.setDateTo("2007-04-01");
        req.setUpdatedFrom("2007-01-01 00:00:00");
        req.setUpdatedTo("2007-01-02 00:00:00");
        req.setPage(1);
        req.setPerPage(10);
        req.setFolder(FolderTypes.ACTIVE);
        req.setMethod("invoice.list");

        assertRequest("model/request/invoice.list.xml", req);
    }

    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/invoice.list.xml");

        Invoice inv = response.getInvoices().get(0);
        
        assertEquals("344", inv.getId());
        assertEquals("0", inv.getContacts().get(0).getId());
        assertEquals(FolderTypes.ACTIVE, inv.getFolder());
        assertEquals(BigDecimal.valueOf(40), inv.getLines().get(0).getAmount());
    }
}
