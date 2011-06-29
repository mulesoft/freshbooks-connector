package org.mule.modules.freshbooks;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLNamespaceFilter extends XMLFilterImpl {
    public XMLNamespaceFilter(XMLReader arg0) {
        super(arg0);
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        super.startElement("", localName, qName,
                attributes);
    }
}