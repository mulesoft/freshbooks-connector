
package org.mule.modules.freshbooks.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.TestableConnection;
import org.mule.modules.freshbooks.Config;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class ConfigFreshBooksConnectorAdapter
    extends Config
    implements ConnectionManagementConnectionAdapter<Config, ConnectionManagementConfigFreshBooksConnectorConnectionKey> , TestableConnection<ConnectionManagementConfigFreshBooksConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigFreshBooksConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getApiUrl(), connectionKey.getConsumerKey(), connectionKey.getConsumerSecret());
    }

    @Override
    public void test(ConnectionManagementConfigFreshBooksConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getApiUrl(), connectionKey.getConsumerKey(), connectionKey.getConsumerSecret());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionIdentifier();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public Config getStrategy() {
        return this;
    }

}
