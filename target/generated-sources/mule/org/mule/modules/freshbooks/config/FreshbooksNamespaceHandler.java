
package org.mule.modules.freshbooks.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/freshbooks</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class FreshbooksNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(FreshbooksNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [freshbooks] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [freshbooks] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new FreshBooksConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-callback", new CreateCallbackDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-callback", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-callbacks", new ListCallbacksDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-callbacks", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-callback", new DeleteCallbackDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-callback", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("verify-callback", new VerifyCallbackDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("verify-callback", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-category", new CreateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-category", new UpdateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-category", new GetCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-category", new DeleteCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-categories", new ListCategoriesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-categories", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-client", new CreateClientDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-client", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-client", new UpdateClientDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-client", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-client", new GetClientDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-client", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-client", new DeleteClientDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-client", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("undelete-client", new UndeleteClientDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("undelete-client", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-clients", new ListClientsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-clients", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-invoice", new CreateInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-invoice", new UpdateInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-invoice", new GetInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-invoice", new DeleteInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("undelete-invoice", new UndeleteInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("undelete-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-invoices", new ListInvoicesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-invoices", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-item", new CreateItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-item", new UpdateItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-item", new GetItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-item", new DeleteItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-items", new ListItemsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-items", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-tax", new CreateTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-tax", new UpdateTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-tax", new GetTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-tax", new DeleteTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-taxes", new ListTaxesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-taxes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-task", new CreateTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-task", new UpdateTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-task", new GetTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-task", new DeleteTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-tasks", new ListTasksDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-tasks", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-payment", new CreatePaymentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-payment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-payment", new UpdatePaymentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-payment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-payment", new GetPaymentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-payment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-payment", new DeletePaymentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-payment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-payments", new ListPaymentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-payments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-current-user-information", new GetCurrentUserInformationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-current-user-information", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-session", new CreateSessionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-session", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-license", new CreateLicenseDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-license", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-licenses", new ListLicensesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-licenses", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-license", new DeleteLicenseDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-license", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-addons", new ListAddonsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-addons", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-system-user", new CreateSystemUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-system-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("auth-user", new AuthUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("auth-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-access-token", new GetAccessTokenDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-access-token", "@Processor", ex);
        }
    }

}
