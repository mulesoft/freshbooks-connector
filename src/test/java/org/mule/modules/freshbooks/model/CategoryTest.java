package org.mule.modules.freshbooks.model;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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
