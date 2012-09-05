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
import org.mule.modules.freshbooks.model.Callback;
import org.mule.modules.freshbooks.model.Category;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.modules.freshbooks.model.Line;

public class FreshbooksModuleTestDriver
{
    private static FreshbooksModule module;
    private static String SOURCE_TOKEN = "sourceToken";
    
    @BeforeClass
    public static void init()
    {
        module = new FreshbooksModule();
        module.setApiUrl("https://mulesofttest.freshbooks.com/api/2.1/xml-in");
        module.setAuthenticationToken("4d8a62a53ec1b3426a625abd039babd9");
        module.init();
    }

    @Test
    public void createACategoryAndDeleteIt()
    {
        Category cat =  new Category();
        cat.setName("MegaMarket3");
        
        Category category = module.createCategory(SOURCE_TOKEN, cat);
        module.deleteCategory(SOURCE_TOKEN, category);
    }

    @Test
    public void createClientAndDeleteIt(String id) {
        Client client = new Client();
        client.setFirstName("Test FB - " + id);
        client.setLastName("Last Name - Test");
        client.setOrganization("ABC INC");
        client.setEmail(String.format("test-FB-%s@test.com", id));
        Client newClient = module.createClient(SOURCE_TOKEN, client);
        module.deleteClient(SOURCE_TOKEN, newClient);
    }

    @Test
    public void createInvoiceAndDeleteIt() {
        Invoice invoice = new Invoice();
        invoice.setClientId("10");
        Line line = new Line();
        line.setQuantity(1);
        line.setUnitCost(Double.valueOf(4));
        invoice.getLines().add(line);
        Invoice newInvoice = module.createInvoice(SOURCE_TOKEN, invoice);
        module.deleteInvoice(SOURCE_TOKEN, newInvoice);
    }

    @Test
    public void createCallbackAndDeleteIt() {
        Callback callback = new Callback();
        callback.setEvent("invoice.update");
        callback.setUri("http://example2.com");
        
        Callback newCallback = module.createCallback(SOURCE_TOKEN, callback);
        module.deleteCallback(SOURCE_TOKEN, newCallback);
    }

    @Test
    public void verifyCallback() {
        Callback callback = new Callback();
        callback.setId("1");
        callback.setVerifier("123123123");
        
        module.verifyCallback(SOURCE_TOKEN, callback);
    }
}
