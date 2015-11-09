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
import org.mule.modules.freshbooks.model.Category;
import org.mule.modules.freshbooks.model.CategoryRequest;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class CategoryTest extends RequestAndResponseUtil {
    
    @Test
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        CategoryRequest req = new CategoryRequest();
        Category cat = new Category();
        req.setCategory(cat);
        cat.setName("Gasoline");
        req.setMethod("category.create");
        assertRequest("model/request/category.create.xml", req);
    }

    @Test
    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.create.xml");
        assertThat(response.getCategoryId(), is("12"));
    }

    @Test
    public void testUpdateRequest() throws JAXBException, IOException, SAXException {
        CategoryRequest req = new CategoryRequest();
        Category cat = new Category();
        req.setCategory(cat);
        cat.setName("Gasoline");
        cat.setId("12");
        req.setMethod("category.update");
        assertRequest("model/request/category.update.xml", req);
    }

    @Test
    public void testUpdateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.update.xml");
        assertThat(response.getStatus(), is("ok"));
    }

    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/category.list.xml");
        assertThat(response.getCategories().size(), is(2));
        assertThat(response.getCategories().get(0).getName(), is("Food"));
    }
}
