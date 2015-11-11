/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.modules.freshbooks.automation.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.freshbooks.automation.unit.CallbackTest;
import org.mule.modules.freshbooks.automation.unit.CategoryTest;
import org.mule.modules.freshbooks.automation.unit.ClientTest;
import org.mule.modules.freshbooks.automation.unit.InvoiceTest;
import org.mule.modules.freshbooks.automation.unit.ItemTest;
import org.mule.modules.freshbooks.automation.unit.PaymentTest;

@RunWith(Suite.class)
@SuiteClasses({
        CallbackTest.class,
        CategoryTest.class,
        ClientTest.class,
        InvoiceTest.class,
        ItemTest.class,
        PaymentTest.class })
public class UnitTestSuite {

}
