package org.mule.modules.freshbooks;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author gaston ponti
 *
 */
public class MapBuilder {
    private final Map<String, Object> map = new HashMap<String, Object>();
               
    public MapBuilder with(String propertyName, Object property)
    {
        map.put(propertyName, property);
        return this;
    }
   
    public Map<String, Object> build()
    {
        return map;
    }
}
