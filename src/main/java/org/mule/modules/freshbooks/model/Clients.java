package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType
public class Clients extends Paged<Client> {
    @XmlElement(name="client")
    public ArrayList<Client> getCLients() {
        return getContents();
    }
}
