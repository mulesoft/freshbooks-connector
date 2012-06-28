package org.mule.modules.freshbooks.model;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.modules.freshbooks.RequestAndResponseTest;
import org.xml.sax.SAXException;

public class PaymentTest extends RequestAndResponseTest {
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        PaymentRequest req = new PaymentRequest();
        Payment pay = new Payment();

        pay.setClientId("13");
        pay.setInvoiceId("207");
        pay.setDate("2007-05-30");
        pay.setAmount(BigDecimal.valueOf(129.88));
        pay.setCurrencyCode("CAD");
        pay.setType(PaymentTypes.CHECK);
        pay.setNotes("Prompt payment!");
        req.setPayment(pay);
        req.setMethod("payment.create");

        assertRequest("model/request/payment.create.xml", req);
    }
    
    public void testListRequest() throws JAXBException, IOException, SAXException {
        PaymentRequest req = new PaymentRequest();
        req.setClientId("3");
        req.setInvoiceId("133");
        req.setDateFrom("2007-01-01");
        req.setDateTo("2007-04-01");
        req.setUpdatedFrom("2007-01-01");
        req.setUpdatedTo("2007-04-01");
        
        req.setPage(1);
        req.setPerPage(10);
        req.setMethod("payment.list");

        assertRequest("model/request/payment.list.xml", req);
    }

    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/payment.get.xml");

        Payment pay = response.getPayment();
        
        assertEquals("109", pay.getId());
        assertEquals(PaymentTypes.VISA, pay.getType());
    }
    
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/payment.list.xml");

        Payment pay = response.getPayments().get(0);
        
        assertEquals("165", pay.getId());
        assertEquals(PaymentTypes.VISA, pay.getType());
    }
}
