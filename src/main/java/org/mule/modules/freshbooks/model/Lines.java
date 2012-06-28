package org.mule.modules.freshbooks.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Lines {
    @XmlElement(name = "line", namespace = "http://www.freshbooks.com/api/")
    private List<Line> lines;
    
    public List<Line> getLines() {
        if(lines == null) {
            lines = new ArrayList<Line>();
        }
        return lines;
    }
}
