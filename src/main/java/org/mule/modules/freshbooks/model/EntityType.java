package org.mule.modules.freshbooks.model;

import org.apache.commons.lang.StringUtils;
import org.mule.modules.freshbooks.FreshbooksException;

public enum EntityType {
    
    CATEGORY(Category.class, "Categories", CategoryRequest.class, CategoryResponse.class),
    
    CLIENT(Client.class, "Clients", ClientRequest.class, ClientResponse.class);
    
    private Class<?> type;
    private String plural;
    private Class<?> requestClazz;
    private Class<?> responseClazz;
    
    private EntityType(Class<?> clazz, String plural, Class<?> requestClazz, Class<?> responseClazz)
    {
        this.type = clazz;
        this.plural = plural;
        this.requestClazz = requestClazz;
        this.responseClazz = responseClazz;
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
    
    public Class<?> getResponseClass()
    {
        return responseClazz;
    }
}
