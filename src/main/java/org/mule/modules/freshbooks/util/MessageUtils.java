/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.io.XMLWriter;
import org.mule.modules.freshbooks.model.ObjectFactory;
import org.xml.sax.helpers.XMLFilterImpl;

public class MessageUtils
{   
    private static MessageUtils freshbooksMessageUtils = null;
    
    private MessageUtils() {}
    
    public static MessageUtils getInstance()
    {
        if (freshbooksMessageUtils == null )
        {
            freshbooksMessageUtils = new MessageUtils();
        }
        
        return freshbooksMessageUtils;
    }
    
    private static class FreshbooksMessageUtilsHelper {
        private static ObjectFactory objectFactory = new ObjectFactory();
        private static JAXBContext privContext = null;
        
        /**
         * Create new or return existing JAXB context for QBO CdmBase classes.
         * @return JAXBContext to Marshall or Unmarshall object
         */
        public static JAXBContext getContext() {
            if (privContext == null) {
                try {
                    privContext =  JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
                } catch (JAXBException e) {
                    throw new RuntimeException(e);
                }
            }
            return privContext;
        }
        
        public static Object getObjectFactory()
        {
            return objectFactory;
        }
    }
    
    /**
     * Create Marshaller from the JAXB context. 
     * @return Marshaller 
     */
    public Marshaller createMarshaller()
    {
        try {
            Marshaller marshaller = getJaxbContext().createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            return marshaller;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Get object of ObjectFactory class generated using JAXB and XSD
     * @return ObjectFactory Class object.
     */
    protected Object getObjectFactory()
    {
        return FreshbooksMessageUtilsHelper.getObjectFactory();
    }
    
    protected JAXBContext getJaxbContext()
    {
        return FreshbooksMessageUtilsHelper.getContext();
    }
    
    /**
     * Create UnMarshaller from the JAXB context. 
     * @return UnMarshaller 
     */
    public Unmarshaller createUnmarshaller()
    {
        try {
            return getJaxbContext().createUnmarshaller();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * This method JAXBElement object to XML String.
     * IDS REST Services process XML string and Responds in XML.
     * @param objectToMarshall
     * @return
     * @throws JAXBException
     */
    public String getXmlDocument(Object objectToMarshall) throws JAXBException
    {
        XMLFilterImpl filter = new XMLNullNamespaceFilter(null);
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer);
        Marshaller marshaller = createMarshaller();
        filter.setContentHandler(xmlWriter);
        marshaller.marshal(objectToMarshall, filter);
        return writer.toString();
    }
    
    /**
     * Clients of this method must make their own determination as to the contents of the response.
     * Generally this can be safely achieved by checking the instanceof.
     * @param responseString
     * @return The unmarshalled response object.
     * @throws JAXBException If the response unmarshaling fails.
     * @throws Exception
     */
    public Object parseResponse(String responseString) throws JAXBException
    {
        Unmarshaller unmarshaller = createUnmarshaller();
        JAXBElement<Object> jaxb = (JAXBElement<Object>) unmarshaller.unmarshal(new StringReader(responseString));

        return jaxb.getValue();
    }
    
    public JAXBElement createJaxbElement(Object obj)
    {
        try
        {
            return (JAXBElement) getObjectFactory().getClass()
                .getMethod("create" + obj.getClass().getSimpleName(), obj.getClass())
                .invoke(getObjectFactory(), obj);
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
    }
}

