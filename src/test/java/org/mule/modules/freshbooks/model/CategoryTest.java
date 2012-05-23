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

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

public class CategoryTest extends RequestAndResponseTest {
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        Request req = new Request();
        Category cat = new Category();
        req.setCategory(cat);
        cat.setName("Gasoline");
        req.setMethod("category.create");

        assertRequest("model/request/category.create.xml", req);
    }

    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.create.xml");

        assertEquals("12", response.getCategoryId());
    }

    public void testUpdateRequest() throws JAXBException, IOException, SAXException {
        Request req = new Request();
        Category cat = new Category();
        req.setCategory(cat);
        cat.setName("Gasoline");
        cat.setId("12");
        req.setMethod("category.update");

        assertRequest("model/request/category.update.xml", req);
    }

    public void testUpdateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.update.xml");
    }

    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.list.xml");
        assertEquals(2, response.getCategories().size());
    }
}
