package org.mule.modules.freshbooks.automation.unit;

/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.modules.freshbooks.automation.util.RequestAndResponseUtil;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.ClientRequest;
import org.mule.modules.freshbooks.model.FolderTypes;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class ClientTest extends RequestAndResponseUtil {

    private static Client client;
    private static ClientRequest request;

    @BeforeClass
    public void setUp() {
        client = new Client();
        client.setFirstName("Jane");
        client.setLastName("Doe");
        client.setOrganization("ABC Corp");
        client.setEmail("janedoe@freshbooks.com");
        client.setUsername("janedoe");
        client.setPassword("seCret!7");
        client.setWorkPhone("(555) 123-4567");
        client.setHomePhone("(555) 234-5678");
        client.setLanguage("en");
        client.setCurrencyCode("USD");
        client.setStreet1("123 Fake St.");
        client.setStreet2("Unit 555");
        client.setCity("New York");
        client.setState("New York");
        client.setCountry("United States");
        client.setCode("553132");

        request = new ClientRequest();
        request.setEmail("janedoe@freshbooks.com");
        request.setUsername("janedoe");
        request.setUpdatedFrom("2009-01-01 00:00:00");
        request.setUpdatedTo("2009-12-01 00:00:00");
        request.setPage(1);
        request.setPerPage(15);
        request.setFolder(FolderTypes.ACTIVE);
        request.setNotes("email");
        request.setMethod("client.list");
    }

    @Test
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        ClientRequest req = new ClientRequest();
        req.setClient(client);
        req.setMethod("client.create");
        assertRequest("model/request/client.create.xml", req);
    }

    @Test
    public void testCreateResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.create.xml");
        assertThat(response.getClientId(), is("13"));
    }

    @Test
    public void testUpdateRequest() throws JAXBException, IOException, SAXException {
        ClientRequest req = new ClientRequest();
        req.setClient(client);
        req.setMethod("client.update");
        assertRequest("model/request/client.update.xml", req);
    }

    @Test
    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.get.xml");
        Client cli = response.getClient();
        assertThat(cli.getCredits().get(0).getCurrency(), is("USD"));
        assertThat(cli.getContacts().get(0).getId(), is("15"));
    }

    @Test
    public void testListRequest() throws JAXBException, IOException, SAXException {
        assertRequest("model/request/client.list.xml", request);
    }

    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/client.list.xml");
        assertThat(response.getClients().get(0).getCredits().get(0).getCurrency(), is("USD"));
        assertThat(response.getClients().get(0).getContacts().get(0).getId(), is("15"));
    }

}
