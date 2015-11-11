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
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mule.modules.freshbooks.automation.util.RequestAndResponseUtil;
import org.mule.modules.freshbooks.model.FolderTypes;
import org.mule.modules.freshbooks.model.Item;
import org.mule.modules.freshbooks.model.ItemRequest;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class ItemTest extends RequestAndResponseUtil {

    @Test
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

    @Test
    public void testListRequest() throws JAXBException, IOException, SAXException {
        ItemRequest req = new ItemRequest();
        req.setPage(1);
        req.setPerPage(5);
        req.setFolder(FolderTypes.ACTIVE);
        req.setMethod("item.list");
        assertRequest("model/request/item.list.xml", req);
    }

    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/item.list.xml");
        Item item = response.getItems().get(0);
        assertThat(item.getId(), is("18"));
        assertThat(item.getUnitCost(), is(BigDecimal.valueOf(34.99)));
        assertThat(item.getFolder(), is(FolderTypes.ACTIVE));
    }
}
