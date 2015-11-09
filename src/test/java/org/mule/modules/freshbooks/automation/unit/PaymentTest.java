/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.freshbooks.automation.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.modules.freshbooks.automation.util.RequestAndResponseUtil;
import org.mule.modules.freshbooks.model.Payment;
import org.mule.modules.freshbooks.model.PaymentRequest;
import org.mule.modules.freshbooks.model.PaymentTypes;
import org.mule.modules.freshbooks.model.Response;
import org.xml.sax.SAXException;

public class PaymentTest extends RequestAndResponseUtil {
    
    private static Payment payment;
    private static PaymentRequest request;
    
    @BeforeClass
    public void setUp(){
        
        payment = new Payment();
        payment.setClientId("13");
        payment.setInvoiceId("207");
        payment.setDate("2007-05-30");
        payment.setAmount(BigDecimal.valueOf(129.88));
        payment.setCurrencyCode("CAD");
        payment.setType(PaymentTypes.CHECK);
        payment.setNotes("Prompt payment!");
        
        request = new PaymentRequest();
        request.setClientId("3");
        request.setInvoiceId("133");
        request.setDateFrom("2007-01-01");
        request.setDateTo("2007-04-01");
        request.setUpdatedFrom("2007-01-01");
        request.setUpdatedTo("2007-04-01");
        request.setPage(1);
        request.setPerPage(10);
        request.setMethod("payment.list");
        
    }
    @Test
    public void testCreateRequest() throws JAXBException, IOException, SAXException {
        PaymentRequest req = new PaymentRequest();
        req.setPayment(payment);
        req.setMethod("payment.create");
        assertRequest("model/request/payment.create.xml", req);
    }
    
    @Test
    public void testListRequest() throws JAXBException, IOException, SAXException {
        assertRequest("model/request/payment.list.xml", request);
    }

    @Test
    public void testGetResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/payment.get.xml");
        Payment payment = response.getPayment();
        assertThat(payment.getId(), is("109"));
        assertThat(payment.getType(), is(PaymentTypes.VISA));
    }
    
    @Test
    public void testListResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
        Response response = parseResponse("model/response/payment.list.xml");
        assertThat(response.getPayments().size(), is(1));
        Payment payment = response.getPayments().get(0);   
        assertThat(payment.getId(), is("165"));
        assertThat(payment.getType(), is(PaymentTypes.VISA));
    }
}
