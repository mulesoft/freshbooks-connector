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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.freshbooks.api.DefaultFreshbooksClient;
import org.mule.modules.freshbooks.api.FreshbooksClient;
import org.mule.modules.freshbooks.model.Categories;
import org.mule.modules.freshbooks.model.Category;
import org.mule.modules.freshbooks.model.Client;
import org.mule.modules.freshbooks.model.Clients;
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.modules.freshbooks.model.InvoiceStatusEnum;
import org.mule.modules.freshbooks.model.Invoices;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;

/**
 *
 * FreshBooks
 *
 * @author Emiliano Lesende
 *
 */
@Module(name = "freshbooks", schemaVersion= "1.0")
public class FreshbooksModule {
    private static final Logger LOGGER = Logger.getLogger(FreshbooksModule.class);

    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.freshbooks.model").build();
    
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
     * Create a new category. If successful, returns the category id of the newly created item.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-category}
     * 
     * @param name The name of the category
     * @return The category id
     */
    @Processor
    public String createCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return freshbooksClient.create(EntityType.CATEGORY, category);
    }

    /**
     * Update an existing expense category with the given category_id. Any category fields left out of the request will remain unchanged.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-category}
     *
     * @param categoryId ID of the category to update
     * @param name       New name
     */
    @Processor
    public void updateCategory(String categoryId, String name) {
        Category category = new Category();
        category.setName(name);
        category.setId(categoryId);
        
        freshbooksClient.update(EntityType.CATEGORY, category);
    }

    /**
     * Return the complete category details associated with the given category_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-category}
     *
     * @param categoryId The Id of the category to retrieve
     * @return A {@link Category} object
     */
    @Processor
    public Category getCategory(String categoryId) {
        return (Category) freshbooksClient.get(EntityType.CATEGORY, categoryId);
    }

    /**
     * Delete an existing expense category.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-category}
     *
     * @param categoryId The Id of the category to delete
     */
    @Processor
    public void deleteCategory(String categoryId) {
        freshbooksClient.delete(EntityType.CATEGORY, categoryId);
    }

    /**
     * Returns a list of expense categories.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-categories}
     *
     * @return A list of categories
     * @throws FreshbooksException
     */
    @Processor
    public Categories listCategories() {
        return (Categories) freshbooksClient.list(EntityType.CATEGORY);
    }

    /**
     * Create a new client and return the corresponding client_id. If a password is not supplied, one will be created at random.
     *
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:create-client}
     *
     * @param firstName        First name
     * @param lastName         Last name
     * @param organization     Organization
     * @param email            Email
     * @param username         Username
     * @param password         Password. Defaults to random password.
     * @param workPhone        Work phone
     * @param homePhone        Home phone
     * @param mobile           Mobile
     * @param fax              Fax
     * @param language         Language
     * @param currencyCode     Currency code
     * @param notes            Notes
     * @param primaryStreet1   Primary street address
     * @param primaryStreet2   Primary street address 2
     * @param primaryCity      Primary city
     * @param primaryState     Primary state
     * @param primaryCountry   Primary country
     * @param primaryZipCode   Primary zip code
     * @param secondaryStreet1 Secondary street address
     * @param secondaryStreet2 Secondary street address 2
     * @param secondaryCity    Secondary city
     * @param secondaryState   Secondary state
     * @param secondaryCountry Secondary country
     * @param secondaryZipCode Secondary zip code
     * @param vatName          VAT name
     * @param vatNumber        VAT number
     * @return The id of the new client
     * @throws FreshbooksException
     */
    @Processor
    public String createClient(String firstName, 
                               String lastName, 
                               String organization,
                               String email, 
                               @Optional String username,
                               @Optional String password,
                               @Optional String workPhone,
                               @Optional String homePhone,
                               @Optional String mobile,
                               @Optional String fax,
                               @Optional @Default("en") String language,
                               @Optional String currencyCode,
                               @Optional String notes,
                               @Optional String primaryStreet1,
                               @Optional String primaryStreet2,
                               @Optional String primaryCity,
                               @Optional String primaryState,
                               @Optional String primaryCountry,
                               @Optional String primaryZipCode,
                               @Optional String secondaryStreet1,
                               @Optional String secondaryStreet2,
                               @Optional String secondaryCity,
                               @Optional String secondaryState,
                               @Optional String secondaryCountry,
                               @Optional String secondaryZipCode,
                               @Optional String vatName,
                               @Optional String vatNumber) {
        
        Client client = (Client) mom.unmap(new MapBuilder()
                          .with("firstName", firstName)
                          .with("lastName", lastName)
                          .with("organization", organization)
                          .with("email", email)
                          .with("username", username)
                          .with("password", password)
                          .with("workPhone", workPhone)
                          .with("homePhone", homePhone)
                          .with("mobile", mobile)
                          .with("fax", fax)
                          .with("language", language)
                          .with("currencyCode", currencyCode)
                          .with("notes", notes)
                          .with("primaryStreet1", primaryStreet1)
                          .with("primaryStreet2", primaryStreet2)
                          .with("primaryCity", primaryCity)
                          .with("primaryState", primaryState)
                          .with("primaryCountry", primaryCountry)
                          .with("primaryZipCode", primaryZipCode)
                          .with("secondaryStreet1", secondaryStreet1)
                          .with("secondaryStreet2", secondaryStreet2)
                          .with("secondaryCity", secondaryCity)
                          .with("secondaryState", secondaryState)
                          .with("secondaryCountry", secondaryCountry)
                          .with("secondaryZipCode", secondaryZipCode)
                          .with("vatName", vatName)
                          .with("vatNumber", vatNumber)
                        , Client.class);
        return freshbooksClient.create(EntityType.CLIENT, client);
    }

    /**
     * Update the details of the client with the given client_id. Any fields not referenced in the request will remain unchanged.
     *
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-client}
     *
     * @param clientId         Client Id to update
     * @param firstName        First name
     * @param lastName         Last name
     * @param organization     Organization
     * @param email            Email
     * @param username         Username
     * @param password         Password. Defaults to random password.
     * @param workPhone        Work phone
     * @param homePhone        Home phone
     * @param mobile           Mobile
     * @param fax              Fax
     * @param language         Language
     * @param currencyCode     Currency code
     * @param notes            Notes
     * @param primaryStreet1   Primary street address
     * @param primaryStreet2   Primary street address 2
     * @param primaryCity      Primary city
     * @param primaryState     Primary state
     * @param primaryCountry   Primary country
     * @param primaryZipCode   Primary zip code
     * @param secondaryStreet1 Secondary street address
     * @param secondaryStreet2 Secondary street address 2
     * @param secondaryCity    Secondary city
     * @param secondaryState   Secondary state
     * @param secondaryCountry Secondary country
     * @param secondaryZipCode Secondary zip code
     * @param vatName          VAT name
     * @param vatNumber        VAT number
     * @return The id of the new client
     * @throws FreshbooksException
     */
    @Processor
    public void updateClient(String clientId, 
                             String firstName, 
                             String lastName, 
                             String organization,
                             String email, 
                             @Optional String username,
                             @Optional String password,
                             @Optional String workPhone,
                             @Optional String homePhone,
                             @Optional String mobile,
                             @Optional String fax,
                             @Optional String language,
                             @Optional String currencyCode,
                             @Optional String notes,
                             @Optional String primaryStreet1,
                             @Optional String primaryStreet2,
                             @Optional String primaryCity,
                             @Optional String primaryState,
                             @Optional String primaryCountry,
                             @Optional String primaryZipCode,
                             @Optional String secondaryStreet1,
                             @Optional String secondaryStreet2,
                             @Optional String secondaryCity,
                             @Optional String secondaryState,
                             @Optional String secondaryCountry,
                             @Optional String secondaryZipCode,
                             @Optional String vatName,
                             @Optional String vatNumber) {
        Client client = (Client) mom.unmap(new MapBuilder()
                        .with("id", clientId)
                        .with("firstName", firstName)
                        .with("lastName", lastName)
                        .with("organization", organization)
                        .with("email", email)
                        .with("username", username)
                        .with("password", password)
                        .with("workPhone", workPhone)
                        .with("homePhone", homePhone)
                        .with("mobile", mobile)
                        .with("fax", fax)
                        .with("language", language)
                        .with("currencyCode", currencyCode)
                        .with("notes", notes)
                        .with("street1", primaryStreet1)
                        .with("street2", primaryStreet2)
                        .with("city", primaryCity)
                        .with("state", primaryState)
                        .with("country", primaryCountry)
                        .with("zipCode", primaryZipCode)
                        .with("secondaryStreet1", secondaryStreet1)
                        .with("secondaryStreet2", secondaryStreet2)
                        .with("secondaryCity", secondaryCity)
                        .with("secondaryState", secondaryState)
                        .with("secondaryCountry", secondaryCountry)
                        .with("secondaryZipCode", secondaryZipCode)
                        .with("vatName", vatName)
                        .with("vatNumber", vatNumber)
                      , Client.class);
        freshbooksClient.update(EntityType.CLIENT, client);
    }

    /**
     * Return the client details associated with the given client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-client}
     * 
     * @param clientId the id of the client to retrieve
     * @return A {@link Client}
     * @throws FreshbooksException
     */
    @Processor
    public Client getClient(String clientId) {
        return (Client) freshbooksClient.get(EntityType.CLIENT, clientId);
    }

    /**
     * Delete the client with the given client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-client}
     *
     * @param clientId the id of the client to retrieve
     * @throws FreshbooksException
     */
    @Processor
    public void deleteClient(String clientId) 
    {
        freshbooksClient.delete(EntityType.CLIENT, clientId);
    }

    /**
     * Returns a list of client summaries in order of descending client_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-clients}
     *
     * @return A list of clients
     * @throws FreshbooksException
     */
    @Processor
    public Clients listClients() 
    {
        return (Clients) freshbooksClient.list(EntityType.CLIENT);
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
     * 
     * @param clientId         Client being invoiced.
     * @param contacts         List of Contact.
     * @param number           Number.
     * @param status           Status. One of sent, viewed or draft. Defaults to draft.
     * @param date             Date. If not supplied, defaults to today's date.
     * @param poNumber         PO Number.
     * @param discount         Percent Discount.
     * @param notes            Notes.
     * @param currencyCode     Currency Code. Defaults to your base currency.
     * @param terms            Terms.
     * @param returnUri        Return URI.
     * @param firstName        First Name.
     * @param lastName         Last Name.
     * @param organization     Organization.
     * @param primaryStreet1   Primary street address.
     * @param primaryStreet2   Primary street address 2.
     * @param primaryCity      Primary city.
     * @param primaryState     Primary state.
     * @param primaryCountry   Primary country.
     * @param primaryZipCode   Primary zip code.
     * @param language         Language code, defaults to the client's language.
     * @param vatName          VAT Name. If set, shown with vat_name under client address.
     * @param vatNumber        VatNumber.
     * @param lines            List of Line. Specify one or more line elements.
     * @return The invoiceId.
     * @throws FreshbooksException
     */
    @Processor
    public String createInvoice(String clientId,
                                @Optional List<Map<String, Object>> contacts,
                                @Optional String number,
                                @Optional InvoiceStatusEnum status,
                                @Optional String date,
                                @Optional String poNumber,
                                @Optional Double discount,
                                @Optional String notes,
                                @Optional String currencyCode,
                                @Optional String terms,
                                @Optional String returnUri,
                                @Optional String firstName,
                                @Optional String lastName,
                                @Optional String organization,
                                @Optional String primaryStreet1,
                                @Optional String primaryStreet2,
                                @Optional String primaryCity,
                                @Optional String primaryState,
                                @Optional String primaryCountry,
                                @Optional String primaryZipCode,
                                @Optional String language,
                                @Optional String vatName,
                                @Optional String vatNumber,
                                @Optional List<Map<String, Object>> lines
                                )
    {
        Invoice invoice = (Invoice) mom.unmap(new MapBuilder()
                .with("clientId", clientId)
                .with("contacts", contacts)
                .with("number", number)
                .with("status", status)
                .with("date", date)
                .with("poNumber", poNumber)
                .with("discount", BigDecimal.valueOf(discount))
                .with("notes", notes)
                .with("currencyCode", currencyCode)
                .with("terms", terms)
                .with("returnUri", returnUri)
                .with("firstName", firstName)
                .with("lastName", lastName)
                .with("organization", organization)
                .with("street1", primaryStreet1)
                .with("street2", primaryStreet2)
                .with("city", primaryCity)
                .with("state", primaryState)
                .with("country", primaryCountry)
                .with("code", primaryZipCode)
                .with("language", language)
                .with("vatName", vatName)
                .with("vatNumber", vatNumber)
                .with("lines", lines)
                .build()
             , Invoice.class);

        return freshbooksClient.create(EntityType.INVOICE, invoice);
    }
    
    /**
     * <p>Update an existing invoice with the given invoice_id. Any invoice fields left 
     * out of the request will remain unchanged.</p>
     * <p> * If you do not specify a lines element, the existing lines will remain unchanged. 
     * If you do specify lines elements the original ones will be replaced by the new ones.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:update-invoice}
     * 
     * @param invoiceId        Invoice to update.
     * @param clientId         Client being invoiced.
     * @param contacts         List of Contact.
     * @param number           Number.
     * @param status           Status. One of sent, viewed or draft. Defaults to draft.
     * @param date             Date. If not supplied, defaults to today's date.
     * @param poNumber         PO Number.
     * @param discount         Percent Discount.
     * @param notes            Notes.
     * @param currencyCode     Currency Code. Defaults to your base currency.
     * @param terms            Terms.
     * @param returnUri        Return URI.
     * @param firstName        First Name.
     * @param lastName         Last Name.
     * @param organization     Organization.
     * @param primaryStreet1   Primary street address.
     * @param primaryStreet2   Primary street address 2.
     * @param primaryCity      Primary city.
     * @param primaryState     Primary state.
     * @param primaryCountry   Primary country.
     * @param primaryZipCode   Primary zip code.
     * @param language         Language code, defaults to the client's language.
     * @param vatName          VAT Name. If set, shown with vat_name under client address.
     * @param vatNumber        VatNumber.
     * @param lines            List of Line. Specify one or more line elements.
     * @throws FreshbooksException
     */
    @Processor 
    public void updateInvoice(String invoiceId,
                              String clientId,
                              @Optional List<Map<String, Object>> contacts,
                              @Optional String number,
                              @Optional InvoiceStatusEnum status,
                              @Optional String date,
                              @Optional String poNumber,
                              @Optional Double discount,
                              @Optional String notes,
                              @Optional String currencyCode,
                              @Optional String terms,
                              @Optional String returnUri,
                              @Optional String firstName,
                              @Optional String lastName,
                              @Optional String organization,
                              @Optional String primaryStreet1,
                              @Optional String primaryStreet2,
                              @Optional String primaryCity,
                              @Optional String primaryState,
                              @Optional String primaryCountry,
                              @Optional String primaryZipCode,
                              @Optional String language,
                              @Optional String vatName,
                              @Optional String vatNumber,
                              @Optional List<Map<String, Object>> lines)
    {
        Invoice invoice = (Invoice) mom.unmap(new MapBuilder()
                .with("id", invoiceId)
                .with("clientId", clientId)
                .with("contacts", contacts)
                .with("number", number)
                .with("status", status)
                .with("date", date)
                .with("poNumber", poNumber)
                .with("discount", BigDecimal.valueOf(discount))
                .with("notes", notes)
                .with("currencyCode", currencyCode)
                .with("terms", terms)
                .with("returnUri", returnUri)
                .with("firstName", firstName)
                .with("lastName", lastName)
                .with("organization", organization)
                .with("street1", primaryStreet1)
                .with("street2", primaryStreet2)
                .with("city", primaryCity)
                .with("state", primaryState)
                .with("country", primaryCountry)
                .with("code", primaryZipCode)
                .with("language", language)
                .with("vatName", vatName)
                .with("vatNumber", vatNumber)
                .with("lines", lines)
                .build()
             , Invoice.class);
        
        freshbooksClient.update(EntityType.INVOICE, invoice);
    }
    
    /**
     * <p>Return the complete invoice details associated with the given invoice_id.</p>
     * <p> * You can use the links element to provide your customers with direct links to 
     * the invoice for editing, viewing by the client and viewing by an administrator.</p>
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:get-invoice}
     * 
     * @param invoiceId Id of the Invoice to be retrieved.
     * @return The invoice retrieved.
     * @throws FreshbooksException.
     */
    @Processor
    public Invoice getInvoice(String invoiceId)
    {
        return (Invoice) freshbooksClient.get(EntityType.INVOICE, invoiceId);
    }
    
    /**
     * Delete an existing invoice.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:delete-invoice}
     * 
     * @param invoiceId Id of the Invoice to be deleted
     * @throws FreshbooksException.
     */
    @Processor
    public void deleteInvoice(String invoiceId)
    {
        freshbooksClient.delete(EntityType.INVOICE, invoiceId);
    }
    
    /**
     * Returns a list of invoice summaries. Results are ordered by descending invoice_id.
     * 
     * {@sample.xml ../../../doc/mule-module-freshbooks.xml.sample freshbooks:list-invoices}
     * 
     * @return A list of Invoices
     * @throws FreshbooksException.
     */
    @Processor
    public Invoices listInvoices()
    {
        return (Invoices) freshbooksClient.list(EntityType.INVOICE);
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
