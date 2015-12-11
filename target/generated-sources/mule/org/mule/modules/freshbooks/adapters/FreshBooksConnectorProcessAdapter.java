
package org.mule.modules.freshbooks.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.freshbooks.FreshBooksConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>FreshBooksConnectorProcessAdapter</code> is a wrapper around {@link FreshBooksConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class FreshBooksConnectorProcessAdapter
    extends FreshBooksConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<FreshBooksConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, FreshBooksConnectorCapabilitiesAdapter> getProcessTemplate() {
        final FreshBooksConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,FreshBooksConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, FreshBooksConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, FreshBooksConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
