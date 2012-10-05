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

import org.apache.commons.lang.StringUtils;
import org.mule.modules.freshbooks.FreshbooksException;

public enum EntityType {
    
    CALLBACK(Callback.class, "Callbacks", CallbackRequest.class),
    
    CATEGORY(Category.class, "Categories", CategoryRequest.class),
    
    CLIENT(Client.class, "Clients", ClientRequest.class),
    
    INVOICE(Invoice.class, "Invoices", InvoiceRequest.class),
    
    ITEM(Item.class, "Items", ItemRequest.class),
    
    LICENSE(License.class, "Licenses", LicenseRequest.class),
    
    PAYMENT(Payment.class, "Payments", PaymentRequest.class),
    
    SESSION(Session.class, "Sessions", SessionRequest.class),

    STAFF(Staff.class, "Staffs", StaffRequest.class),

    SYSTEM(System.class, "Systems", SystemRequest.class),
    
    TASK(Task.class, "Tasks", TaskRequest.class),
    
    TAX(Tax.class, "Taxes", TaxRequest.class);
    
    private Class<?> type;
    private String plural;
    private Class<?> requestClazz;
    
    private EntityType(Class<?> clazz, String plural, Class<?> requestClazz)
    {
        this.type = clazz;
        this.plural = plural;
        this.requestClazz = requestClazz;
    }
    
    public Class<?> getType()
    {
        return type;
    }
    
    public String getSimpleName()
    {
        return type.getSimpleName();
    }
    
    public String getResourceName()
    {
        return StringUtils.uncapitalize(getSimpleName());
    }
    
    public String getNameForLists()
    {
        return plural;
    }
    
    public BaseRequest getRequest()
    {
        try {
            return (BaseRequest) requestClazz.newInstance();
        } catch (Exception e) {
            throw new FreshbooksException(e.getMessage());
        }
    }
}
