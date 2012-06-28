package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Credits {
    @XmlElement(name = "credit", namespace = "http://www.freshbooks.com/api/")
    private List<Credit> credits;
    
    public List<Credit> getCredits() {
        if(credits == null) {
            credits = new ArrayList<Credit>();
        }
        return credits;
    }
}
