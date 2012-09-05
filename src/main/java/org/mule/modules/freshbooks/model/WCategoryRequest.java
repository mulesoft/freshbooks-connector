/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.model;

public class WCategoryRequest {
    private CategoryRequest categoryRequest;

    public WCategoryRequest() {

    }
    
    public WCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }
    
    /**
     * @return the categoryRequest
     */
    public CategoryRequest getCategoryRequest() {
        return categoryRequest;
    }

    /**
     * @param categoryRequest the categoryRequest to set
     */
    public void setCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }
    
    
}
