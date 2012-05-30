package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class Line {

    @XmlElement(name = "name", required = false)
    protected String name;
    
    @XmlElement(name = "description", required = false)
    protected String description;
    @XmlElement(name = "unit_cost", required = false)
    protected Double unitCost;
    @XmlElement(name = "quantity", required = false)
    protected Integer quantity;
    @XmlElement(name = "tax1_name", required = false)
    protected String tax1Name;
    @XmlElement(name = "tax2_name", required = false)
    protected String tax2Name;
    @XmlElement(name = "tax1_percent", required = false)
    protected String tax1Percent;
    @XmlElement(name = "tax2Percent", required = false)
    protected String tax2Percent;
    @XmlElement(name = "type", required = false)
    protected LineTypeEnum type;
//  <lines>     <!-- Specify one or more line elements (Optional) -->  
//    <line>  
//      <name>Yard Work</name>                       <!-- (Optional) -->  
//      <description>Mowed the lawn.</description>   <!-- (Optional) -->  
//      <unit_cost>10</unit_cost>                    <!-- Default is 0 -->  
//      <quantity>4</quantity>                       <!-- Default is 0 -->  
//      <tax1_name>GST</tax1_name>                   <!-- (Optional) -->  
//      <tax2_name>PST</tax2_name>                   <!-- (Optional) -->  
//      <tax1_percent>5</tax1_percent>               <!-- (Optional) -->  
//      <tax2_percent>8</tax2_percent>               <!-- (Optional) -->  
//      <type>Item</type>                            <!-- (Optional) -->  
//   <!-- One of 'Item' or 'Time'. If omitted, the line's type defaults to 'Item' -->  
//    </line>  
//  </lines>  
//</invoice>
    
    public LineTypeEnum getType() {
        if(type == null)
            return LineTypeEnum.ITEM;
        return type;
    }
}
