/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */
package org.mule.modules.freshbooks;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.freshbooks.api.DefaultFreshbooksClient;
import org.mule.modules.freshbooks.api.FreshbooksClient;
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
import org.mule.modules.freshbooks.model.Payment;
import org.mule.modules.freshbooks.model.PaymentRequest;
import org.mule.modules.freshbooks.model.WCallback;
import org.mule.modules.freshbooks.model.WCallbackRequest;
import org.mule.modules.freshbooks.model.WCategory;
import org.mule.modules.freshbooks.model.WCategoryRequest;
import org.mule.modules.freshbooks.model.WClient;
import org.mule.modules.freshbooks.model.WClientRequest;
import org.mule.modules.freshbooks.model.WInvoice;
import org.mule.modules.freshbooks.model.WInvoiceRequest;
import org.mule.modules.freshbooks.model.WItem;
import org.mule.modules.freshbooks.model.WItemRequest;
import org.mule.modules.freshbooks.model.WPayment;
import org.mule.modules.freshbooks.model.WPaymentRequest;

/**
 *
 * FreshBooks
 *
 * @author Emiliano Lesende
 *
 */
@Module(name = "freshbooks", schemaVersion= "1.0", friendlyName = "FreshBooks")
public class FreshbooksModule {
    
    /**
     * Authentication Token
     */
    @Configurable
    private String authenticationToken;

    /**
     * Api URL
     */
    @Configurable
    private String apiUrl;

    private FreshbooksClient freshbooksClient;

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    /**
     * Create a new callback for a specific event or a set of events.
     *
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-callback}
     *
     * <p>Valid events</p>
     * <p> * all</p>
     * <p> * category</p>
     * <p> * category.create</p>
     * <p> * category.delete</p>
     * <p> * category.update</p>
     * <p> * client</p>
     * <p> * client.create</p>
     * <p> * client.delete</p>
     * <p> * client.update</p>
     * <p> * estimate</p>
     * <p> * estimate.create</p>
     * <p> * estimate.delete</p>
     * <p> * estimate.sendByEmail</p>
     * <p> * estimate.update</p>
     * <p> * expense</p>
     * <p> * expense.create</p>
     * <p> * expense.delete</p>
     * <p> * expense.update</p>
     * <p> * invoice</p>
     * <p> * invoice.create</p>
     * <p> * invoice.delete</p>
     * <p> * invoice.dispute</p>
     * <p> * invoice.pastdue.1</p>
     * <p> * invoice.pastdue.2</p>
     * <p> * invoice.pastdue.3</p>
     * <p> * invoice.sendByEmail</p>
     * <p> * invoice.sendBySnailMail</p>
     * <p> * invoice.update</p>
     * <p> * item</p>
     * <p> * item.create</p>
     * <p> * item.delete</p>
     * <p> * item.update</p>
     * <p> * payment</p>
     * <p> * payment.create</p>
     * <p> * payment.delete</p>
     * <p> * payment.update</p>
     * <p> * project</p>
     * <p> * project.create</p>
     * <p> * project.delete</p>
     * <p> * project.update</p>
     * <p> * recurring</p>
     * <p> * recurring.create</p>
     * <p> * recurring.delete</p>
     * <p> * recurring.update</p>
     * <p> * staff</p>
     * <p> * staff.create</p>
     * <p> * staff.delete</p>
     * <p> * staff.update</p>
     * <p> * task</p>
     * <p> * task.create</p>
     * <p> * task.delete</p>
     * <p> * task.update</p>
     * <p> * time_entry</p>
     * <p> * time_entry.create</p>
     * <p> * time_entry.delete</p>
     * <p> * time_entry.update</p>
     * @param callback wrapper of a {@link Callback}
     * @return callback id
     */
    @Processor
    public String createCallback(@Optional @Default("#[payload]") WCallback callback)
    {
        return freshbooksClient.create(EntityType.CALLBACK, callback.getCallback());
    }
    
    /**
     * Return a list of registered callbacks. You can optionally filter by event or uri.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-callbacks}
     * 
     * @param callbackRequest wrapper of a {@link CallbackRequest}
     * @return iterable of callbacks
     */
    @Processor
    public Iterable<Callback> listCallbacks(@Optional @Default("#[payload]") WCallbackRequest callbackRequest)
    {
        return freshbooksClient.list(EntityType.CALLBACK, callbackRequest.getCallbackRequest());
    }

    /**
     * Deletes a callback.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-callback}
     * 
     * @param callback wrapper of a {@link Callback}
     * @param wCallback
     */
    @Processor
    public void deleteCallback(@Optional @Default("#[payload]") WCallback callback)
    {
        freshbooksClient.delete(EntityType.CALLBACK, callback.getCallback().getId());
    }
    
    /**
     * Create a new category. If successful, returns the category id of the newly created item.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-category}
     * 
     * @param category wrapper of a {@link Category}
     * @return The created category
     */
    @Processor
    public WCategory createCategory(@Optional @Default("#[payload]") WCategory category) {
        String newCategoryId = freshbooksClient.create(EntityType.CATEGORY, category.getCategory());
        category.getCategory().setId(newCategoryId);
        return category;
    }

    /**
     * Update an existing expense category with the given category_id. Any category fields left out of the request will remain unchanged.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-category}
     *
     * @param category wrapper of a {@link Category}
     * @return updated category
     * 
     */
    @Processor
    public WCategory updateCategory(@Optional @Default("#[payload]") WCategory category) {
        freshbooksClient.update(EntityType.CATEGORY, category.getCategory());
        return category;
    }

    /**
     * Return the complete category details associated with the given category_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-category}
     *
     * @param categoryId    The category id
     * @return A {@link Category} object
     */
    @Processor
    public WCategory getCategory(String categoryId) {
        return new WCategory((Category) freshbooksClient.get(EntityType.CATEGORY, categoryId));
    }

    /**
     * Delete an existing expense category.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-category}
     *
     * @param category wrapper of a {@link Category}
     */
    @Processor
    public void deleteCategory(@Optional @Default("#[payload]") WCategory category) {
        freshbooksClient.delete(EntityType.CATEGORY, category.getCategory().getId());
    }

    /**
     * Returns a list of expense categories.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-categories}
     *
     * @param categoryRequest wrapper of a {@link CategoryRequest}
     * @return A iterable of categories
     * @throws FreshbooksException
     */
    @Processor
    public Iterable<Category> listCategories(@Optional @Default("#[payload]") WCategoryRequest categoryRequest) {
        return freshbooksClient.<Category>list(EntityType.CATEGORY, categoryRequest.getCategoryRequest());
    }

    /**
     * Create a new client and return the corresponding client_id. If a password is not supplied, one will be created at random.
     *
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-client}
     *
     * @param client wrapper of a {@link Client}
     * @return The created client
     * @throws FreshbooksException
     */
    @Processor
    public WClient createClient(@Optional @Default("#[payload]") WClient client) {
        String newClientId = freshbooksClient.create(EntityType.CLIENT, client.getClient());
        client.getClient().setId(newClientId);
        return client;
    }

    /**
     * Update the details of the client with the given client_id. Any fields not referenced in the request will remain unchanged.
     *
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-client}
     * @param client wrapper of a {@link Client}
     * @return updated client
     * @throws FreshbooksException
     */
    @Processor
    public WClient updateClient(@Optional @Default("#[payload]") WClient client) {
        freshbooksClient.update(EntityType.CLIENT, client.getClient());
        return client;
    }

    /**
     * Return the client details associated with the given client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-client}
     * 
     * @param clientId  The client id
     * @return A {@link Client}
     * @throws FreshbooksException
     */
    @Processor
    public WClient getClient(String clientId) {
        return new WClient((Client) freshbooksClient.get(EntityType.CLIENT, clientId));
    }

    /**
     * Delete the client with the given client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-client}
     * @param client wrapper of a {@link Client}
     * @throws FreshbooksException
     */
    @Processor
    public void deleteClient(@Optional @Default("#[payload]") WClient client) 
    {
        freshbooksClient.delete(EntityType.CLIENT, client.getClient().getId());
    }
    
    /**
     * Undelete a client
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:undelete-client}
     * @param client wrapper of a {@link Client}
     * @return the undeleted client id
     * @throws FreshbooksException
     */
    @Processor
    public String undeleteClient(@Optional @Default("#[payload]") WClient client) 
    {
        freshbooksClient.undelete(EntityType.CLIENT, client.getClient().getId());
        return client.getClient().getId();
    }

    /**
     * Returns a list of client summaries in order of descending client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-clients}
     * @param clientRequest wrapper of a {@link ClientRequest}
     * @return A iterable of clients
     * @throws FreshbooksException
     */
    @Processor
    public Iterable<Client> listClients(@Optional @Default("#[payload]") WClientRequest clientRequest) 
    {
        return freshbooksClient.<Client>list(EntityType.CLIENT, clientRequest.getClientRequest());
    }

    /**
     * <p>Create a new invoice complete with line items. If successful, returns 
     * the invoice_id of the newly created invoice.</p>
     * <p>
     *  * If you don't specify an invoice number, it will increment from the last one.<br/>
     *  * You may optionally specify a different address on the invoice; otherwise the 
     *  address will be pulled from your client's details.<br/>
     *  * You may optionally specify a return_uri element. If provided, users will be 
     *  presented with a link to the URI when they pay the invoice.</p>
     *  
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-invoice}
     * @param invoice wrapper of a {@link Invoice}
     * @return The created invoice
     * @throws FreshbooksException
     */
    @Processor
    public WInvoice createInvoice(@Optional @Default("#[payload]") WInvoice invoice)
    {
        String newInvoiceId = freshbooksClient.create(EntityType.INVOICE, invoice.getInvoice());
        invoice.getInvoice().setId(newInvoiceId);
        return invoice;
    }
    
    /**
     * <p>Update an existing invoice with the given invoice_id. Any invoice fields left 
     * out of the request will remain unchanged.</p>
     * <p> * If you do not specify a lines element, the existing lines will remain unchanged. 
     * If you do specify lines elements the original ones will be replaced by the new ones.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-invoice}
     * 
     * @param invoice wrapper of a {@link Invoice}
     * @return updated invoice
     * @throws FreshbooksException
     */
    @Processor 
    public WInvoice updateInvoice(@Optional @Default("#[payload]") WInvoice invoice)
    {
        freshbooksClient.update(EntityType.INVOICE, invoice.getInvoice());
        return invoice;
    }
    
    /**
     * <p>Return the complete invoice details associated with the given invoice_id.</p>
     * <p> * You can use the links element to provide your customers with direct links to 
     * the invoice for editing, viewing by the client and viewing by an administrator.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-invoice}
     * 
     * @param invoiceId     The invoice id
     * @return The invoice retrieved.
     * @throws FreshbooksException.
     */
    @Processor
    public WInvoice getInvoice(String invoiceId)
    {
        return new WInvoice((Invoice) freshbooksClient.get(EntityType.INVOICE, invoiceId));
    }
    
    /**
     * Delete an existing invoice.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-invoice}
     * 
     * @param invoice wrapper of a {@link Invoice}
     * @throws FreshbooksException.
     */
    @Processor
    public void deleteInvoice(@Optional @Default("#[payload]") WInvoice invoice)
    {
        freshbooksClient.delete(EntityType.INVOICE, invoice.getInvoice().getId());
    }
    
    /**
     * Undelete an invoice
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:undelete-invoice}
     * 
     * @param invoice wrapper of a {@link Invoice}
     * @return The undeleted invoice id
     * @throws FreshbooksException.
     */
    @Processor
    public String undeleteInvoice(@Optional @Default("#[payload]") WInvoice invoice)
    {
        freshbooksClient.undelete(EntityType.INVOICE, invoice.getInvoice().getId());
        return invoice.getInvoice().getId();
    }
    
    /**
     * Returns a list of invoice summaries. Results are ordered by descending invoice_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-invoices}
     * @param invoiceRequest wrapper of a {@link InvoiceRequest}
     * @return A iterable of Invoices
     * @throws FreshbooksException.
     */
    @Processor
    public Iterable<Invoice> listInvoices(@Optional @Default("#[payload]") WInvoiceRequest invoiceRequest)
    {
        return freshbooksClient.<Invoice>list(EntityType.INVOICE, invoiceRequest.getInvoiceRequest());
    }
    
    /**
     * <p>Create a new item and return the corresponding item_id. </p>
     *  
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-item}
     * @param item wrapper of a {@link Item}
     * @return The created item
     * @throws FreshbooksException
     */
    @Processor
    public WItem createItem(@Optional @Default("#[payload]") WItem item)
    {
        String newItemId = freshbooksClient.create(EntityType.ITEM, item.getItem());
        item.getItem().setId(newItemId);
        return item;
    }
    
    /**
     * <p>Update an existing item. All fields aside from the item_id are optional; 
     * by omitting a field, the existing value will remain unchanged. </p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-item}
     * 
     * @param item wrapper of a {@link Item}
     * @return updated item
     * @throws FreshbooksException
     */
    @Processor 
    public WItem updateItem(@Optional @Default("#[payload]") WItem item)
    {
        freshbooksClient.update(EntityType.ITEM, item.getItem());
        return item;
    }
    
    /**
     * <p>Get an existing item with the given item_id. </p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-item}
     * 
     * @param itemId    The item id
     * @return The item retrieved.
     * @throws FreshbooksException.
     */
    @Processor
    public WItem getItem(String itemId)
    {
        return new WItem((Item) freshbooksClient.get(EntityType.ITEM, itemId));
    }
    
    /**
     * Delete an existing item.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-item}
     * 
     * @param item wrapper of a {@link Item}
     * @throws FreshbooksException.
     */
    @Processor
    public void deleteItem(@Optional @Default("#[payload]") WItem item)
    {
        freshbooksClient.delete(EntityType.ITEM, item.getItem().getId());
    }
    
    /**
     * Returns a list of items, ordered by descending item_id. 
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-items}
     * @param itemRequest wrapper of a {@link ItemRequest}
     * @return A iterable of Items
     * @throws FreshbooksException.
     */
    @Processor
    public Iterable<Item> listItems(@Optional @Default("#[payload]") WItemRequest itemRequest)
    {
        return freshbooksClient.<Item>list(EntityType.ITEM, itemRequest.getItemRequest());
    }
    
    /**
     * Create a new payment and returns the corresponding payment_id.
     * <p>This function can have one of three possible effects depending on the presence of invoice_id and client_id:</p>
     * <p> * If you specify an invoice_id only, the payment will be recorded as an invoice payment.</p>
     * <p> * If you specify a client_id only, the payment will be recorded as a client credit.</p>
     * <p> * If you specify both an invoice_id and client_id, the payment will be recorded as an invoice payment, 
     * and the amount will be subtracted from the client's credit.</p>
     * <p>Note that 'currency_code' can only be provided when creating a credit, not a regular payment. Regular payments 
     * will default to the currency code of the invoice they are being made against.</p> 
     *  
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-payment}
     * @param payment wrapper of a {@link Payment}
     * @return The created Payment
     * @throws FreshbooksException
     */
    @Processor
    public WPayment createPayment(@Optional @Default("#[payload]") WPayment payment)
    {
        String newPaymentId = freshbooksClient.create(EntityType.PAYMENT, payment.getPayment());
        payment.getPayment().setId(newPaymentId);
        return payment;
    }
    
    /**
     * <p>Update an existing payment. All fields besides payment_id are optional - unpassed 
     * fields will retain their existing value.</p>
     * <p>Note that 'currency_code' can only be provided when updating a credit, not a regular payment. 
     * Regular payments will default to the currency code of the invoice they are being made against.</p> 
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-payment}
     * 
     * @param payment wrapper of a {@link Payment}
     * @return updated Payment
     * @throws FreshbooksException
     */
    @Processor 
    public WPayment updatePayment(@Optional @Default("#[payload]") WPayment payment)
    {
        freshbooksClient.update(EntityType.PAYMENT, payment.getPayment());
        return payment;
    }
    
    /**
     * <p>Retrieve payment details according to payment_id. </p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-payment}
     * 
     * @param paymentId     The payment id
     * @return The payment retrieved.
     * @throws FreshbooksException.
     */
    @Processor
    public WPayment getPayment(String paymentId)
    {
        return new WPayment((Payment) freshbooksClient.get(EntityType.PAYMENT, paymentId));
    }
    
    /**
     * Permanently delete a payment. This will modify the status of the associated invoice if required.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-payment}
     * 
     * @param payment wrapper of a {@link Payment}
     * @throws FreshbooksException.
     */
    @Processor
    public void deletePayment(@Optional @Default("#[payload]") WPayment payment)
    {
        freshbooksClient.delete(EntityType.PAYMENT, payment.getPayment().getId());
    }
    
    /**
     * Returns a list of payment summaries. Results are ordered by descending payment_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-payments}
     * @param paymentRequest wrapper of a {@link PaymentRequest}
     * @return A iterable of Payments
     * @throws FreshbooksException.
     */
    @Processor
    public Iterable<Payment> listPayments(@Optional @Default("#[payload]") WPaymentRequest paymentRequest)
    {
        return freshbooksClient.<Payment>list(EntityType.PAYMENT, paymentRequest.getPaymentRequest());
    }
    
    @PostConstruct
    public void init()
    {
        if (freshbooksClient == null )
        {
            freshbooksClient = new DefaultFreshbooksClient(apiUrl, authenticationToken);
        }
    }
}
