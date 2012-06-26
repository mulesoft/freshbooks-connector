package org.mule.modules.freshbooks.model;

public class CategoryResponse extends BaseResponse {
    
    private String categoryId;
    private Category category;
    private Categories categories;
    
    public CategoryResponse(Response response) {
        initBaseResponseFields(response);
        categoryId = response.getCategoryId();
        category = response.getCategory();
        categories = response.getCategories();
    }
    
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
