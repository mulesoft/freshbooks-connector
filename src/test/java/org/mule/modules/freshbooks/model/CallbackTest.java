/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

public class CallbackTest extends RequestAndResponseTest {
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        CallbackRequest req = new CallbackRequest();
        Callback call = new Callback();
        req.setCallback(call);
        call.setUri("http://example.com/webhooks/ready");
        call.setEvent("invoice.update");
        req.setMethod("callback.create");

        assertRequest("model/request/callback.create.xml", req);
    }

    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/callback.create.xml");

        assertEquals("20", response.getCallbackId());
    }

    public void testListRequest() throws JAXBException, IOException, SAXException {
        CallbackRequest req = new CallbackRequest();
        req.setUri("http://example.com/webhooks/ready");
        req.setEvent("invoice.create");
        req.setMethod("callback.list");

        assertRequest("model/request/callback.list.xml", req);
    }
    
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/callback.list.xml");
        assertEquals(2, response.getCallbacks().size());
        assertEquals("21" , response.getCallbacks().get(1).getId());
    }
}
