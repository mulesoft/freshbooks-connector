/**
 * Mule Freshbooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.freshbooks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.mule.modules.freshbooks.model.BaseRequest;
import org.mule.modules.freshbooks.model.BaseResponse;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public abstract class RequestAndResponseTest extends XMLTestCase {
    protected void assertRequest(String file, BaseRequest req) throws IOException, SAXException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(BaseRequest.class);
        Marshaller marshaller = jc.createMarshaller();
        OutputStream stream = new OutputStream() {
            private final StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            //Netbeans IDE automatically overrides this toString()
            @Override
            public String toString() {
                return this.string.toString();
            }
        };

        marshaller.marshal(req, stream);
        String expected = getResourceAsString(new ClassPathResource(file).getInputStream());
        //String expected = getResourceAsString(getClass().getClassLoader().getResourceAsStream(file));
        String output = stream.toString();

        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expected, output);
    }

    private static String getResourceAsString(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        byte[] buf = new byte[1024];
        int sz = 0;
        try {
            while (true) {
                sz = in.read(buf);

                baos.write(buf, 0, sz);
                if (sz < buf.length)
                    break;
            }
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        }
        return new String(baos.toByteArray());
    }

    protected BaseResponse parseResponse(String file) throws JAXBException, SAXException, ParserConfigurationException {
        JAXBContext jc = JAXBContext.newInstance(BaseResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

                // Create the XMLReader
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader reader = factory.newSAXParser().getXMLReader();

        // The filter class to set the correct namespace
        XMLFilterImpl xmlFilter = new XMLNamespaceFilter(reader);
        reader.setContentHandler(unmarshaller.getUnmarshallerHandler());
        SAXSource source = new SAXSource(xmlFilter, new InputSource(getClass().getClassLoader().getResourceAsStream(file)));

        return (BaseResponse)unmarshaller.unmarshal(source);
    }
}
