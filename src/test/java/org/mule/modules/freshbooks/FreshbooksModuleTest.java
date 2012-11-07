/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.freshbooks.api.DefaultFreshbooksClient;
import org.mule.modules.freshbooks.api.OAuthCredentials;
import org.mule.modules.freshbooks.api.ObjectStoreHelper;
import org.mule.modules.freshbooks.model.Callback;
import org.mule.modules.freshbooks.model.CallbackRequest;
import org.mule.modules.freshbooks.model.Category;
import org.mule.modules.freshbooks.model.CategoryRequest;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.ClientRequest;
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.modules.freshbooks.model.InvoiceRequest;
import org.mule.modules.freshbooks.model.Item;
import org.mule.modules.freshbooks.model.ItemRequest;
import org.mule.modules.freshbooks.model.License;
import org.mule.modules.freshbooks.model.Payment;
import org.mule.modules.freshbooks.model.PaymentRequest;
import org.mule.modules.freshbooks.model.Session;
import org.mule.modules.freshbooks.model.Staff;
import org.mule.modules.freshbooks.model.Task;
import org.mule.modules.freshbooks.model.TaskRequest;
import org.mule.modules.freshbooks.model.Tax;
import org.mule.modules.freshbooks.model.TaxRequest;

public class FreshbooksModuleTest {

    private static String ACCESS_TOKEN_ID = "accessTokenId";
    private static String SOURCE_TOKEN = "sourceToken";

    @Mock
    private static ObjectStoreHelper objectStoreHelper;
    @Mock
    private static DefaultFreshbooksClient freshbooksClient;
    @Mock
    private static OAuthCredentials credentials;
    
    private static FreshbooksModule module;
    
    //OBJECTS
    @Mock
    private static org.mule.modules.freshbooks.model.System systemUser;
    @Mock
    private static Staff staff;
    @Mock
    private static Category category;
    @Mock
    private static Callback callback;
    @Mock
    private static Client client;
    @Mock
    private static Invoice invoice;
    @Mock
    private static Item item;
    @Mock
    private static Tax tax;
    @Mock
    private static Task task;
    @Mock
    private static Payment payment;
    @Mock
    private static Session session;
    @Mock
    private static License license;
    @Mock
    private static CallbackRequest callbackRequest;
    @Mock
    private static CategoryRequest categoryRequest;
    @Mock
    private static ClientRequest clientRequest;
    @Mock
    private static InvoiceRequest invoiceRequest;
    @Mock
    private static ItemRequest itemRequest;
    @Mock
    private static TaxRequest taxRequest;
    @Mock
    private static TaskRequest taskRequest;
    @Mock
    private static PaymentRequest paymentRequest;
    
    @Before
    public void setUp() throws ObjectStoreException {
        MockitoAnnotations.initMocks(this);
        module = new FreshbooksModule();
        module.setFreshbooksClient(freshbooksClient);
        module.setObjectStoreHelper(objectStoreHelper);
        when(module.getObjectStoreHelper().retrieve(ACCESS_TOKEN_ID)).thenReturn(credentials);
    }

    @Test
    public void testCreateCallback() {
        Callback callback = new Callback();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.CALLBACK, callback, true)).thenReturn("callbackId");
        callback.setId("callbackId");
        assertEquals(callback, module.createCallback(SOURCE_TOKEN, callback, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testDeleteCallback() {
        module.deleteCallback(SOURCE_TOKEN, callback, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testVerifyCallback() {
        assertEquals(callback, module.verifyCallback(SOURCE_TOKEN, callback, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testListCallbacks() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.CALLBACK, callbackRequest)).thenReturn(createList());
        assertEquals(createList(), module.listCallbacks(SOURCE_TOKEN, callbackRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateCategory() {
        Category category = new Category();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.CATEGORY, category, true)).thenReturn("categoryId");
        category.setId("categoryId");
        assertEquals(category, module.createCategory(SOURCE_TOKEN, category, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateCategory() {
        assertEquals(category, module.updateCategory(SOURCE_TOKEN, category, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetCategory() {
        Category category = new Category();
        category.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.CATEGORY, category.getId())).thenReturn(category);
        assertEquals(category.getId(), module.getCategory(SOURCE_TOKEN, category.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteCategory() {
        module.deleteCategory(SOURCE_TOKEN, category, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListCategories() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.CATEGORY, categoryRequest)).thenReturn(createList());
        assertEquals(createList(), module.listCategories(SOURCE_TOKEN, categoryRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateClient() {
        Client client = new Client();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.CLIENT, client, true)).thenReturn("clientId");
        client.setId("clientId");
        assertEquals(client, module.createClient(SOURCE_TOKEN, client, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateClient() {
        assertEquals(client, module.updateClient(SOURCE_TOKEN, client, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetClient() {
        Client client = new Client();
        client.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.CLIENT, client.getId())).thenReturn(client);
        assertEquals(client.getId(), module.getClient(SOURCE_TOKEN, client.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteClient() {
        module.deleteClient(SOURCE_TOKEN, client, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListClients() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.CLIENT, clientRequest)).thenReturn(createList());
        assertEquals(createList(), module.listClients(SOURCE_TOKEN, clientRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUndeleteClient() {
        Client client = new Client();
        client.setId("Id");
        assertEquals(client.getId(), module.undeleteClient(SOURCE_TOKEN, client, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateInvoice() {
        Invoice invoice = new Invoice();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.INVOICE, invoice, true)).thenReturn("invoiceId");
        invoice.setId("InvoiceId");
        assertEquals(invoice, module.createInvoice(SOURCE_TOKEN, invoice, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateInvoice() {
        assertEquals(invoice, module.updateInvoice(SOURCE_TOKEN, invoice, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.INVOICE, invoice.getId())).thenReturn(invoice);
        assertEquals(invoice.getId(), module.getInvoice(SOURCE_TOKEN, invoice.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteInvoice() {
        module.deleteInvoice(SOURCE_TOKEN, invoice, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListInvoices() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.INVOICE, invoiceRequest)).thenReturn(createList());
        assertEquals(createList(), module.listInvoices(SOURCE_TOKEN, invoiceRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUndeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("id");
        assertEquals(invoice.getId(), module.undeleteInvoice(SOURCE_TOKEN, invoice, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateItem() {
        Item item = new Item();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.ITEM, item, true)).thenReturn("itemId");
        item.setId("itemId");
        assertEquals(item, module.createItem(SOURCE_TOKEN, item, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateItem() {
        assertEquals(item, module.updateItem(SOURCE_TOKEN, item, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetItem() {
        Item item = new Item();
        item.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.ITEM, item.getId())).thenReturn(item);
        assertEquals(item.getId(), module.getItem(SOURCE_TOKEN, item.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteItem() {
        module.deleteItem(SOURCE_TOKEN, item, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListItems() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.ITEM, itemRequest)).thenReturn(createList());
        assertEquals(createList(), module.listItems(SOURCE_TOKEN, itemRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateTax() {
        Tax tax = new Tax();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.TAX, tax, true)).thenReturn("taxId");
        tax.setId("taxId");
        assertEquals(tax, module.createTax(SOURCE_TOKEN, tax, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateTax() {
        assertEquals(tax, module.updateTax(SOURCE_TOKEN, tax, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetTax() {
        Tax tax = new Tax();
        tax.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.TAX, tax.getId())).thenReturn(tax);
        assertEquals(tax.getId(), module.getTax(SOURCE_TOKEN, tax.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteTax() {
        module.deleteTax(SOURCE_TOKEN, tax, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListTaxes() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.TAX, taxRequest)).thenReturn(createList());
        assertEquals(createList(), module.listTaxes(SOURCE_TOKEN, taxRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateTask() {
        Task task = new Task();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.TASK, task, true)).thenReturn("taskId");
        task.setId("taskId");
        assertEquals(task, module.createTask(SOURCE_TOKEN, task, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdateTask() {
        assertEquals(task, module.updateTask(SOURCE_TOKEN, task, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetTask() {
        Task task = new Task();
        task.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.TASK, task.getId())).thenReturn(task);
        assertEquals(task.getId(), module.getTask(SOURCE_TOKEN, task.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeleteTask() {
        module.deleteTask(SOURCE_TOKEN, task, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListTasks() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.TASK, taskRequest)).thenReturn(createList());
        assertEquals(createList(), module.listTasks(SOURCE_TOKEN, taskRequest, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.PAYMENT, payment, true)).thenReturn("paymentId");
        task.setId("paymentId");
        assertEquals(payment, module.createPayment(SOURCE_TOKEN, payment, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testUpdatePayment() {
        assertEquals(payment, module.updatePayment(SOURCE_TOKEN, payment, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testGetPayment() {
        Payment payment = new Payment();
        payment.setId("id");
        when(freshbooksClient.get(credentials, 
                SOURCE_TOKEN, EntityType.PAYMENT, payment.getId())).thenReturn(payment);
        assertEquals(payment.getId(), module.getPayment(SOURCE_TOKEN, payment.getId(), ACCESS_TOKEN_ID).getId());
    }

    @Test
    public void testDeletePayment() {
        module.deletePayment(SOURCE_TOKEN, payment, ACCESS_TOKEN_ID);
    }
    
    @Test
    public void testListPayments() {
        when(freshbooksClient.list(credentials, 
                SOURCE_TOKEN, EntityType.PAYMENT, paymentRequest)).thenReturn(createList());
        assertEquals(createList(), module.listPayments(SOURCE_TOKEN, paymentRequest, ACCESS_TOKEN_ID));
    }

    @Test
    public void testGetCurrentUserInformation() {
        when(freshbooksClient.execute(credentials, SOURCE_TOKEN, EntityType.STAFF, "staff.current")).thenReturn(staff);
        assertEquals(staff, module.getCurrentUserInformation(SOURCE_TOKEN, ACCESS_TOKEN_ID, null));
    }
    
    @Test
    public void testCreateSession() {
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.SESSION, session, false)).thenReturn(session);
        assertEquals(session, module.createSession(SOURCE_TOKEN, session, ACCESS_TOKEN_ID));
    }
    
    @Test
    public void testCreateLicense() {
        when(freshbooksClient.create(credentials, SOURCE_TOKEN, 
                EntityType.LICENSE, license, false)).thenReturn(license);
        assertEquals(license, module.createLicense(SOURCE_TOKEN, license, ACCESS_TOKEN_ID));
    }
    
    private Iterable<Object> createList() {
        return new ArrayList<Object>();
    }
}
