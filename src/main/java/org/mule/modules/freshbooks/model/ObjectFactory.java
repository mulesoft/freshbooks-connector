package org.mule.modules.freshbooks.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBElement.GlobalScope;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
        
    private final static QName _Category_QNAME = new QName("http://www.freshbooks.com/api/", "category");
    private final static QName _Categories_QNAME = new QName("http://www.freshbooks.com/api/", "categories");
    private final static QName _CategoryRequest_QNAME = new QName("", "request");
    private final static QName _CategoryResponse_QNAME = new QName("http://www.freshbooks.com/api/", "CategoryResponse");
    
    private final static QName _ClientResponse_QNAME = new QName("http://www.freshbooks.com/api/", "ClientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mule.modules.freshbooks.model
     * 
     */
    public ObjectFactory() {
    }
    
    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }
    
    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }
    
    /**
     * Create an instance of {@link CategoryRequest }
     * 
     */
    public CategoryRequest createCategoryRequest() {
        return new CategoryRequest();
    }
    
    /**
     * Create an instance of {@link CategoryResponse }
     * 
     */
    public CategoryResponse createCategoryResponse() {
        return new CategoryResponse();
    }
    
    /**
     * Create an instance of {@link ClientResponse }
     * 
     */
    public ClientResponse createClientResponse() {
        return new ClientResponse();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Categories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "Categories")
    public JAXBElement<Categories> createCategories(Categories value) {
        return new JAXBElement<Categories>(_Categories_QNAME, Categories.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "CategoryRequest")
    public JAXBElement<CategoryRequest> createCategoryRequest(CategoryRequest value) {
        GlobalScope bla;
        return new JAXBElement<CategoryRequest>(_CategoryRequest_QNAME, CategoryRequest.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "CategoryResponse")
    public JAXBElement<CategoryResponse> createCategoryResponse(CategoryResponse value) {
        return new JAXBElement<CategoryResponse>(_CategoryResponse_QNAME, CategoryResponse.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.freshbooks.com/api/", name = "ClientResponse")
    public JAXBElement<ClientResponse> createClientResponse(ClientResponse value) {
        return new JAXBElement<ClientResponse>(_ClientResponse_QNAME, ClientResponse.class, null, value);
    }
}
