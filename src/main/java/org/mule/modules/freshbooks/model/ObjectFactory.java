/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    
    //private final static QName _Request_QNAME = new QName("", "request");
    private final static QName _Response_QNAME = new QName("http://www.freshbooks.com/api/", "response");
    
    private final static QName _Callback_QNAME = new QName("http://www.freshbooks.com/api/", "callback");
    private final static QName _Callbacks_QNAME = new QName("http://www.freshbooks.com/api/", "callbacks");
    private final static QName _CallbackRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Category_QNAME = new QName("http://www.freshbooks.com/api/", "category");
    private final static QName _Categories_QNAME = new QName("http://www.freshbooks.com/api/", "categories");
    private final static QName _CategoryRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Client_QNAME = new QName("http://www.freshbooks.com/api/", "client");
    private final static QName _Clients_QNAME = new QName("http://www.freshbooks.com/api/", "clients");
    private final static QName _ClientRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Invoice_QNAME = new QName("http://www.freshbooks.com/api/", "invoice");
    private final static QName _Invoices_QNAME = new QName("http://www.freshbooks.com/api/", "invoices");
    private final static QName _InvoiceRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Item_QNAME = new QName("http://www.freshbooks.com/api/", "item");
    private final static QName _Items_QNAME = new QName("http://www.freshbooks.com/api/", "items");
    private final static QName _ItemRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Payment_QNAME = new QName("http://www.freshbooks.com/api/", "payment");
    private final static QName _Payments_QNAME = new QName("http://www.freshbooks.com/api/", "payments");
    private final static QName _PaymentRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Contact_QNAME = new QName("http://www.freshbooks.com/api/", "contact");
    private final static QName _Contacts_QNAME = new QName("http://www.freshbooks.com/api/", "contacts");
    
    private final static QName _Credit_QNAME = new QName("http://www.freshbooks.com/api/", "credit");
    private final static QName _Credits_QNAME = new QName("http://www.freshbooks.com/api/", "credits");
    
    private final static QName _Staff_QNAME = new QName("http://www.freshbooks.com/api/", "staff");
    private final static QName _StaffRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Session_QNAME = new QName("http://www.freshbooks.com/api/", "session");
    private final static QName _SessionRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _System_QNAME = new QName("http://www.freshbooks.com/api/", "system");
    private final static QName _SystemRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Tax_QNAME = new QName("http://www.freshbooks.com/api/", "tax");
    private final static QName _Taxes_QNAME = new QName("http://www.freshbooks.com/api/", "taxes");
    private final static QName _TaxRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    private final static QName _Task_QNAME = new QName("http://www.freshbooks.com/api/", "task");
    private final static QName _Tasks_QNAME = new QName("http://www.freshbooks.com/api/", "tasks");
    private final static QName _TaskRequest_QNAME = new QName("http://www.freshbooks.com/api/", "request");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mule.modules.freshbooks.model
     * 
     */
    public ObjectFactory() {
    }
    
    /**
     * Create an instance of {@link Request }
     * 
     */
    public Response createResponse() {
        return new Response();
    }
    
    /**
     * Create an instance of {@link Callback }
     * 
     */
    public Callback createCallback() {
        return new Callback();
    }
    
    /**
     * Create an instance of {@link Callbacks }
     * 
     */
    public Callbacks createCallbacks() {
        return new Callbacks();
    }
    
    /**
     * Create an instance of {@link CallbackRequest }
     * 
     */
    public CallbackRequest createCallbackRequest() {
        return new CallbackRequest();
    }
    
    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }
    
    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }
    
    /**
     * Create an instance of {@link CategoryRequest }
     * 
     */
    public CategoryRequest createCategoryRequest() {
        return new CategoryRequest();
    }
    
    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }
    
    /**
     * Create an instance of {@link Clients }
     * 
     */
    public Clients createClients() {
        return new Clients();
    }
    
    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }
    
    /**
     * Create an instance of {@link Invoices }
     * 
     */
    public Invoices createInvoices() {
        return new Invoices();
    }
    
    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }
    
    /**
     * Create an instance of {@link Items }
     * 
     */
    public Items createItems() {
        return new Items();
    }
    
    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }
    
    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Payments createPayments() {
        return new Payments();
    }
    
    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }
    
    /**
     * Create an instance of {@link Contacts }
     * 
     */
    public Contacts createContacts() {
        return new Contacts();
    }
    
    /**
     * Create an instance of {@link Credit }
     * 
     */
    public Credit createCredit() {
        return new Credit();
    }
    
    /**
     * Create an instance of {@link Credits }
     * 
     */
    public Credits createCredits() {
        return new Credits();
    }
    
    /**
     * Create an instance of {@link Staff }
     * 
     */
    public Staff createStaff() {
        return new Staff();
    }
    
    /**
     * Create an instance of {@link StaffRequest }
     * 
     */
    public StaffRequest createStaffRequest() {
        return new StaffRequest();
    }
    
    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }
    
    /**
     * Create an instance of {@link SessionRequest }
     * 
     */
    public SessionRequest createSessionRequest() {
        return new SessionRequest();
    }

    /**
     * Create an instance of {@link System }
     * 
     */
    public System createSystem() {
        return new System();
    }
    
    /**
     * Create an instance of {@link SystemRequest }
     * 
     */
    public SystemRequest createSystemRequest() {
        return new SystemRequest();
    }

    /**
     * Create an instance of {@link Tax }
     * 
     */
    public Tax createTax() {
        return new Tax();
    }
    
    /**
     * Create an instance of {@link Taxes }
     * 
     */
    public Taxes createTaxes() {
        return new Taxes();
    }
    
    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }
    
    /**
     * Create an instance of {@link Tasks }
     * 
     */
    public Tasks createTasks() {
        return new Tasks();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Callback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Callback")
    public JAXBElement<Callback> createCallback(Callback value) {
        return new JAXBElement<Callback>(_Callback_QNAME, Callback.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Categories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Callbacks")
    public JAXBElement<Callbacks> createCategories(Callbacks value) {
        return new JAXBElement<Callbacks>(_Callbacks_QNAME, Callbacks.class, null, value);
    }
    
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CallbackRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "CallbackRequest")
    public JAXBElement<CallbackRequest> createCallbackRequest(CallbackRequest value) {
        return new JAXBElement<CallbackRequest>(_CallbackRequest_QNAME, CallbackRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Categories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Categories")
    public JAXBElement<Categories> createCategories(Categories value) {
        return new JAXBElement<Categories>(_Categories_QNAME, Categories.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CategoryRequest")
    public JAXBElement<CategoryRequest> createCategoryRequest(CategoryRequest value) {
        return new JAXBElement<CategoryRequest>(_CategoryRequest_QNAME, CategoryRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Client")
    public JAXBElement<Client> createClient(Client value) {
        return new JAXBElement<Client>(_Client_QNAME, Client.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Clients")
    public JAXBElement<Clients> createCategories(Clients value) {
        return new JAXBElement<Clients>(_Clients_QNAME, Clients.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "ClientRequest")
    public JAXBElement<ClientRequest> createClientRequest(ClientRequest value) {
        return new JAXBElement<ClientRequest>(_ClientRequest_QNAME, ClientRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invoice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Invoice")
    public JAXBElement<Invoice> createInvoice(Invoice value) {
        return new JAXBElement<Invoice>(_Invoice_QNAME, Invoice.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invoices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Invoices")
    public JAXBElement<Invoices> createInvoices(Invoices value) {
        return new JAXBElement<Invoices>(_Invoices_QNAME, Invoices.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "InvoiceRequest")
    public JAXBElement<InvoiceRequest> createInvoiceRequest(InvoiceRequest value) {
        return new JAXBElement<InvoiceRequest>(_InvoiceRequest_QNAME, InvoiceRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Items }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Items")
    public JAXBElement<Items> createItems(Items value) {
        return new JAXBElement<Items>(_Items_QNAME, Items.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "ItemRequest")
    public JAXBElement<ItemRequest> createItemRequest(ItemRequest value) {
        return new JAXBElement<ItemRequest>(_ItemRequest_QNAME, ItemRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Payments")
    public JAXBElement<Payments> createPayments(Payments value) {
        return new JAXBElement<Payments>(_Payments_QNAME, Payments.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "PaymentRequest")
    public JAXBElement<PaymentRequest> createPaymentRequest(PaymentRequest value) {
        return new JAXBElement<PaymentRequest>(_PaymentRequest_QNAME, PaymentRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Credit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Credit")
    public JAXBElement<Credit> createCredit(Credit value) {
        return new JAXBElement<Credit>(_Credit_QNAME, Credit.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Credits }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Credits")
    public JAXBElement<Credits> createCredits(Credits value) {
        return new JAXBElement<Credits>(_Credits_QNAME, Credits.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Contact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Contact")
    public JAXBElement<Contact> createContact(Contact value) {
        return new JAXBElement<Contact>(_Contact_QNAME, Contact.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Contacts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Contacts")
    public JAXBElement<Contacts> createContacts(Contacts value) {
        return new JAXBElement<Contacts>(_Contacts_QNAME, Contacts.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Staff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Staff")
    public JAXBElement<Staff> createStaff(Staff value) {
        return new JAXBElement<Staff>(_Staff_QNAME, Staff.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Staff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "StaffRequest")
    public JAXBElement<StaffRequest> createStaffRequest(StaffRequest value) {
        return new JAXBElement<StaffRequest>(_StaffRequest_QNAME, StaffRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Session }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Session")
    public JAXBElement<Session> createSession(Session value) {
        return new JAXBElement<Session>(_Session_QNAME, Session.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "SessionRequest")
    public JAXBElement<SessionRequest> createSessionRequest(SessionRequest value) {
        return new JAXBElement<SessionRequest>(_SessionRequest_QNAME, SessionRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link System }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "System")
    public JAXBElement<System> createSystem(System value) {
        return new JAXBElement<System>(_System_QNAME, System.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "SystemRequest")
    public JAXBElement<SystemRequest> createSystemRequest(SystemRequest value) {
        return new JAXBElement<SystemRequest>(_SystemRequest_QNAME, SystemRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Tax")
    public JAXBElement<Tax> createTax(Tax value) {
        return new JAXBElement<Tax>(_Tax_QNAME, Tax.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Taxes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Taxes")
    public JAXBElement<Taxes> createTaxes(Taxes value) {
        return new JAXBElement<Taxes>(_Taxes_QNAME, Taxes.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "TaxRequest")
    public JAXBElement<TaxRequest> createTaxRequest(TaxRequest value) {
        return new JAXBElement<TaxRequest>(_TaxRequest_QNAME, TaxRequest.class, null, value);
    }
    

    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Task }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Task")
    public JAXBElement<Task> createTask(Task value) {
        return new JAXBElement<Task>(_Task_QNAME, Task.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Tasks")
    public JAXBElement<Tasks> createTaxes(Tasks value) {
        return new JAXBElement<Tasks>(_Tasks_QNAME, Tasks.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "TaskRequest")
    public JAXBElement<TaskRequest> createTaskRequest(TaskRequest value) {
        return new JAXBElement<TaskRequest>(_TaskRequest_QNAME, TaskRequest.class, null, value);
    }
}
