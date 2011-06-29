package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType
public class Categories extends Paged<Category> {
    @XmlElement(name = "category")
    public ArrayList<Category> getCategories() {
        return getContents();
    }
}
