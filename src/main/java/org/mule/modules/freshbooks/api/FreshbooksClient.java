package org.mule.modules.freshbooks.api;

import org.mule.modules.freshbooks.model.EntityType;

public interface FreshbooksClient {
    
    public String create(EntityType type, Object obj);
    
    public void update(EntityType type, Object obj);
    
    public Object get(EntityType type, String id);
    
    public void delete(EntityType type, String id);
    
    public Object list(EntityType type);
}
