/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.automation.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mule.modules.freshbooks.automation.util.RequestAndResponseUtil;
import org.mule.modules.freshbooks.model.Callback;
import org.mule.modules.freshbooks.model.CallbackRequest;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class CallbackTest extends RequestAndResponseUtil {
    
    @Test
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        CallbackRequest req = new CallbackRequest();
        Callback call = new Callback();
        req.setCallback(call);
        call.setUri("http://example.com/webhooks/ready");
        call.setEvent("invoice.update");
        req.setMethod("callback.create");
        assertRequest("model/request/callback.create.xml", req);
    }

    @Test
    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/callback.create.xml");
        assertThat(response.getCallbackId(), is("20"));
    }

    @Test
    public void testListRequest() throws JAXBException, IOException, SAXException {
        CallbackRequest req = new CallbackRequest();
        req.setUri("http://example.com/webhooks/ready");
        req.setEvent("invoice.create");
        req.setMethod("callback.list");
        assertRequest("model/request/callback.list.xml", req);
    }
    
    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/callback.list.xml");
        assertThat(response.getCallbacks().size(), is(2));
        assertThat(response.getCallbacks().get(1).getId(), is("21"));
    }
}
