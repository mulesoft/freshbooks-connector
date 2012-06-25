package org.mule.modules.freshbooks;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.mule.modules.freshbooks.model.ObjectFactory;

public class FreshbooksMessageUtils
{   
    private static FreshbooksMessageUtils freshbooksMessageUtils = null;
    
    private FreshbooksMessageUtils() {}
    
    public static FreshbooksMessageUtils getInstance()
    {
        if (freshbooksMessageUtils == null )
        {
            freshbooksMessageUtils = new FreshbooksMessageUtils();
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
    public String getXmlDocument(JAXBElement<? extends Object> objectToMarshall) throws JAXBException
    {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = createMarshaller();
        marshaller.marshal(objectToMarshall, writer);
        String documentToPost = writer.toString();
        return documentToPost;
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
//        return unmarshaller.unmarshal(new StringReader(responseString));
        final Object unmarshalledObject = unmarshaller.unmarshal(new StringReader(responseString));
        JAXBElement<Object> jaxb = (JAXBElement<Object>)unmarshalledObject;

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

