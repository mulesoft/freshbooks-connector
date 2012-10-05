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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", namespace = "http://www.freshbooks.com/api/")
public class Response {

    @XmlAttribute
    private String status;
    @XmlElement(required = false, namespace = "http://www.freshbooks.com/api/")
    private String error;
    
    @XmlElement(name = "callback_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String callbackId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Callback callback;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Callbacks callbacks;
    
    @XmlElement(name = "category_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String categoryId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Category category;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Categories categories;
    
    @XmlElement(name = "client_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String clientId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Client client;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Clients clients;
    
    @XmlElement(name = "invoice_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String invoiceId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Invoice invoice;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Invoices invoices;
    
    @XmlElement(name = "item_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String itemId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Item item;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Items items;
    
    @XmlElement(name = "payment_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String paymentId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Payment payment;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Payments payments;
    
    @XmlElement(name = "tax_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String taxId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Tax tax;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Taxes taxes;
    
    @XmlElement(name = "task_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String taskId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Task task;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Tasks tasks;
    
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Staff staff;
    
    @XmlElement(name = "system", namespace = "http://www.freshbooks.com/api/", required = false)
    private System system;
    
    @XmlElement(name = "license_id", namespace = "http://www.freshbooks.com/api/", nillable = true)
    private String licenseId;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private License license;
    @XmlElement(namespace = "http://www.freshbooks.com/api/", required = false)
    private Licenses licenses;
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }
    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
    /**
     * @return the callbackId
     */
    public String getCallbackId() {
        return callbackId;
    }
    /**
     * @param callbackId the callbackId to set
     */
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }
    /**
     * @return the callback
     */
    public Callback getCallback() {
        return callback;
    }
    /**
     * @param callback the callback to set
     */
    public void setCallback(Callback callback) {
        this.callback = callback;
    }
    /**
     * @return the callbacks
     */
    public Callbacks getCallbacks() {
        return callbacks;
    }
    /**
     * @param callbacks the callbacks to set
     */
    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }
    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }
    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * @return the categories
     */
    public Categories getCategories() {
        return categories;
    }
    /**
     * @param categories the categories to set
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }
    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }
    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * @return the clients
     */
    public Clients getClients() {
        return clients;
    }
    /**
     * @param clients the clients to set
     */
    public void setClients(Clients clients) {
        this.clients = clients;
    }
    /**
     * @return the invoiceId
     */
    public String getInvoiceId() {
        return invoiceId;
    }
    /**
     * @param invoiceId the invoiceId to set
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }
    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    /**
     * @return the invoices
     */
    public Invoices getInvoices() {
        return invoices;
    }
    /**
     * @param invoices the invoices to set
     */
    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }
    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }
    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }
    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }
    /**
     * @return the items
     */
    public Items getItems() {
        return items;
    }
    /**
     * @param items the items to set
     */
    public void setItems(Items items) {
        this.items = items;
    }
    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }
    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }
    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    /**
     * @return the payments
     */
    public Payments getPayments() {
        return payments;
    }
    /**
     * @param payments the payments to set
     */
    public void setPayments(Payments payments) {
        this.payments = payments;
    }
    /**
     * @return the staff
     */
    public Staff getStaff() {
        return staff;
    }
    /**
     * @param staff the staff to set
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public String getTaxId() {
        return taxId;
    }
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
    public Tax getTax() {
        return tax;
    }
    public Taxes getTaxes() {
        return taxes;
    }
    public void setTax(Tax tax) {
        this.tax = tax;
    }
    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }
    public String getTaskId() {
        return taskId;
    }
    public Task getTask() {
        return task;
    }
    public Tasks getTasks() {
        return tasks;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }
    public System getSystem() {
        return system;
    }
    public void setSystem(System system) {
        this.system = system;
    }
    public String getLicenseId() {
        return licenseId;
    }
    public License getLicense() {
        return license;
    }
    public Licenses getLicenses() {
        return licenses;
    }
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
    public void setLicense(License license) {
        this.license = license;
    }
    public void setLicenses(Licenses licenses) {
        this.licenses = licenses;
    }
}
