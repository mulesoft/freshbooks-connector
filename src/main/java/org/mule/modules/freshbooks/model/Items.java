package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Items extends Paged<Item> {
    @XmlElement(name = "item", namespace = "http://www.freshbooks.com/api/")
    public ArrayList<Item> getItems() {
        return getContents();
    }
}
