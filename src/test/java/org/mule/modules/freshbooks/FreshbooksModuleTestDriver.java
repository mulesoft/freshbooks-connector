/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */
package org.mule.modules.freshbooks;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.freshbooks.model.Callback;
import org.mule.modules.freshbooks.model.Category;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.modules.freshbooks.model.Line;

public class FreshbooksModuleTestDriver
{
    private static FreshbooksModule module;
    private static String SOURCE_TOKEN = "sourceToken";
    private static final String ACCESS_TOKEN_ID = "";
    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_KEY_SECRET = "";
    private static final String API_URL = "http://api.freshbooks.com";
    
    @BeforeClass
    public static void init() throws ConnectionException
    {
        module = new FreshbooksModule();
        module.setApiUrl(API_URL);
        module.setConsumerKey(CONSUMER_KEY);
        module.setConsumerSecret(CONSUMER_KEY_SECRET);
        module.connect();
    }

    @Test
    public void createACategoryAndDeleteIt()
    {
        Category cat =  new Category();
        cat.setName("MegaMarket3");
        
        Category category = module.createCategory(SOURCE_TOKEN, cat, ACCESS_TOKEN_ID);
        module.deleteCategory(SOURCE_TOKEN, category, ACCESS_TOKEN_ID);
    }

    @Test
    public void createClientAndDeleteIt(String id) {
        Client client = new Client();
        client.setFirstName("Test FB - " + id);
        client.setLastName("Last Name - Test");
        client.setOrganization("ABC INC");
        client.setEmail(String.format("test-FB-%s@test.com", id));
        Client newClient = module.createClient(SOURCE_TOKEN, client, ACCESS_TOKEN_ID);
        module.deleteClient(SOURCE_TOKEN, newClient, ACCESS_TOKEN_ID);
    }

    @Test
    public void createInvoiceAndDeleteIt() {
        Invoice invoice = new Invoice();
        invoice.setClientId("10");
        Line line = new Line();
        line.setQuantity(1);
        line.setUnitCost(Double.valueOf(4));
        invoice.getLines().add(line);
        Invoice newInvoice = module.createInvoice(SOURCE_TOKEN, invoice, ACCESS_TOKEN_ID);
        module.deleteInvoice(SOURCE_TOKEN, newInvoice, ACCESS_TOKEN_ID);
    }

    @Test
    public void createCallbackAndDeleteIt() {
        Callback callback = new Callback();
        callback.setEvent("invoice.update");
        callback.setUri("http://example2.com");
        
        Callback newCallback = module.createCallback(SOURCE_TOKEN, callback, ACCESS_TOKEN_ID);
        module.deleteCallback(SOURCE_TOKEN, newCallback, ACCESS_TOKEN_ID);
    }

    @Test
    public void verifyCallback() {
        Callback callback = new Callback();
        callback.setId("1");
        callback.setVerifier("123123123");
        
        module.verifyCallback(SOURCE_TOKEN, callback, ACCESS_TOKEN_ID);
    }
}
