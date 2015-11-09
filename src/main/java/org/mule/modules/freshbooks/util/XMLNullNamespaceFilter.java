/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLNullNamespaceFilter extends XMLFilterImpl {
    public XMLNullNamespaceFilter(XMLReader arg0) {
        super(arg0);
    }

    private String parseQName(String qName)
    {
        int index = qName.indexOf(":");
        if(index == -1) {
            return qName;
        }
        return qName.substring(index+1);
    }
    
    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        super.startElement(null, localName, parseQName(qName),
                attributes);
    }

    @Override
    public void endElement(String uri, String localName,
                             String qName)
            throws SAXException {
        super.endElement(null, localName, parseQName(qName));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
    
    
}