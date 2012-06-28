package org.mule.modules.freshbooks.model;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

public class ItemTest extends RequestAndResponseTest {
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        ItemRequest req = new ItemRequest();
        Item item = new Item();
          
        item.setName("Fuzzy Slippers");
        item.setDescription("Extra soft");
        item.setUnitCost(BigDecimal.valueOf(59.99));
        item.setQuantity(1);
        item.setInventory(10);
        req.setItem(item);
        req.setMethod("item.create");

        assertRequest("model/request/item.create.xml", req);
    }
    
    public void testListRequest() throws JAXBException, IOException, SAXException {
        ItemRequest req = new ItemRequest();
        req.setPage(1);
        req.setPerPage(5);
        req.setFolder(FolderTypes.ACTIVE);
        req.setMethod("item.list");

        assertRequest("model/request/item.list.xml", req);
    }

    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/item.list.xml");

        Item item = response.getItems().get(0);
        
        assertEquals("18", item.getId());
        assertEquals(BigDecimal.valueOf(34.99), item.getUnitCost());
        assertEquals(FolderTypes.ACTIVE, item.getFolder());
    }
}
