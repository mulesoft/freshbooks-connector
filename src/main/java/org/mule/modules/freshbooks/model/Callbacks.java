package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Callbacks extends Paged<Callback> {
    @XmlElement(name = "callback", namespace = "http://www.freshbooks.com/api/")
    public ArrayList<Callback> getCallback() {
        return getContents();
    }
}
