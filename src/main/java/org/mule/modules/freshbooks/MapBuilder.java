/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

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
