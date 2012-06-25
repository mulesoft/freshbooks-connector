package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({
    Category.class,
    Categories.class
})
//@XmlRootElement(namespace = "http://www.freshbooks.com/api/", name = "response")
//@XmlType(name = "response")
@XmlType(namespace = "http://www.freshbooks.com/api/", name = "CategoryResponse")
public class CategoryResponse extends BaseResponse {
    
    @XmlElement(name = "category_id", nillable=true)
    private String categoryId;
    @XmlElement(name = "category", required = false)
    private Category category;
    @XmlElement(name = "categories", required = false)
    private Categories categories;
    
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
