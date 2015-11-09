package org.mule.modules.freshbooks.automation.functional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.freshbooks.Config;
import org.mule.modules.freshbooks.FreshBooksConnector;
import org.mule.modules.freshbooks.api.DefaultFreshBooksClient;
import org.mule.modules.freshbooks.api.OAuthCredentials;
import org.mule.modules.freshbooks.model.EntityType;
import org.mule.modules.freshbooks.model.Invoice;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;


public class GetInvoiceTestCases extends AbstractTestCase<FreshBooksConnector> {
    
    public GetInvoiceTestCases() {
        super(FreshBooksConnector.class);
    }
    
    @Test
    public void testGetExistingInvoice() throws ConnectionException {
        
        
        Invoice invoice = getConnector().getInvoice(null, "MULE00001", "99b63d59aa7f03e1f1e19e7cda3cd52b");
//        assertThat(invoice, notNullValue());
//        assertThat(invoice.getAmount(), is(new BigDecimal(1200)));
    }

}
