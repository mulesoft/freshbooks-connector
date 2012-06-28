package org.mule.modules.freshbooks.model;

import org.apache.commons.lang.StringUtils;
import org.mule.modules.freshbooks.FreshbooksException;

public enum EntityType {
    
    CALLBACK(Callback.class, "Callbacks", CallbackRequest.class),
    
    CATEGORY(Category.class, "Categories", CategoryRequest.class),
    
    CLIENT(Client.class, "Clients", ClientRequest.class),
    
    INVOICE(Invoice.class, "Invoices", InvoiceRequest.class),
    
    ITEM(Item.class, "Items", ItemRequest.class),
    
    PAYMENT(Payment.class, "Payments", PaymentRequest.class);
    
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
