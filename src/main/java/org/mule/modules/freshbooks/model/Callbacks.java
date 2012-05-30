package org.mule.modules.freshbooks.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Callbacks extends Paged<Callback> {
    @XmlElement(name = "callback")
    public ArrayList<Callback> getCallback() {
        return getContents();
    }
}
