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

public class ClientTest extends RequestAndResponseTest {
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        ClientRequest req = new ClientRequest();
        Client cli = new Client();
        req.setClient(cli);
        cli.setFirstName("Jane");
        cli.setLastName("Doe");
        cli.setOrganization("ABC Corp");
        cli.setEmail("janedoe@freshbooks.com");
        cli.setUsername("janedoe");
        cli.setPassword("seCret!7");
        cli.setWorkPhone("(555) 123-4567");
        cli.setHomePhone("(555) 234-5678");
        cli.setLanguage("en");
        cli.setCurrencyCode("USD");
        cli.setStreet1("123 Fake St.");
        cli.setStreet2("Unit 555");
        cli.setCity("New York");
        cli.setState("New York");
        cli.setCountry("United States");
        cli.setCode("553132");
        req.setMethod("client.create");

        assertRequest("model/request/client.create.xml", req);
    }

    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.create.xml");

        assertEquals("13", response.getClientId());
    }

    public void testUpdateRequest() throws JAXBException, IOException, SAXException {
        ClientRequest req = new ClientRequest();
        Client cli = new Client();
        req.setClient(cli);
        cli.setId("12");
        cli.setFirstName("Jane");
        cli.setLastName("Doe");
        cli.setOrganization("ABC Corp");
        cli.setEmail("janedoe@freshbooks.com");
        cli.setUsername("janedoe");
        cli.setPassword("seCret!7");
        cli.setWorkPhone("(555) 123-4567");
        cli.setHomePhone("(555) 234-5678");
        cli.setLanguage("en");
        cli.setCurrencyCode("USD");
        cli.setStreet1("123 Fake St.");
        cli.setStreet2("Unit 555");
        cli.setCity("New York");
        cli.setState("New York");
        cli.setCountry("United States");
        cli.setCode("553132");
        req.setMethod("client.update");

        assertRequest("model/request/client.update.xml", req);
    }

    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.get.xml");
        Client cli = response.getClient();
        assertEquals("USD", cli.getCredits().get(0).getCurrency());
        assertEquals("15", cli.getContacts().get(0).getId());
    }
    
    public void testListRequest() throws JAXBException, IOException, SAXException {
        ClientRequest req = new ClientRequest();
        req.setEmail("janedoe@freshbooks.com");  
        req.setUsername("janedoe");
        req.setUpdatedFrom("2009-01-01 00:00:00");
        req.setUpdatedTo("2009-12-01 00:00:00");
        req.setPage(1);
        req.setPerPage(15);
        req.setFolder(FolderTypes.ACTIVE);
        req.setNotes("email");
        req.setMethod("client.list");

        assertRequest("model/request/client.list.xml", req);
    }

    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.list.xml");
        assertEquals("USD", response.getClients().get(0).getCredits().get(0).getCurrency());
        assertEquals("15", response.getClients().get(0).getContacts().get(0).getId());
    }
}
