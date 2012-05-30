package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class CategoryRequest extends BaseRequest {
    
    @XmlElement(name = "category_id")
    private String categoryId;
    @XmlElement(name = "category")
    private Category category;
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
