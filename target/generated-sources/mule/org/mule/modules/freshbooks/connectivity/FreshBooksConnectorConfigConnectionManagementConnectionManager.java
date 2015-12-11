
package org.mule.modules.freshbooks.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.api.store.ObjectStore;
import org.mule.common.DefaultTestResult;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.api.lifecycle.LifeCycleManager;
import org.mule.devkit.api.lifecycle.MuleContextAwareManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorFactory;
import org.mule.devkit.internal.connection.management.ConnectionManagementProcessTemplate;
import org.mule.devkit.internal.connection.management.UnableToAcquireConnectionException;
import org.mule.devkit.internal.connectivity.ConnectivityTestingErrorHandler;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.freshbooks.Config;
import org.mule.modules.freshbooks.FreshBooksConnector;
import org.mule.modules.freshbooks.adapters.FreshBooksConnectorConnectionManagementAdapter;
import org.mule.modules.freshbooks.pooling.DevkitGenericKeyedObjectPool;


/**
 * A {@code FreshBooksConnectorConfigConnectionManagementConnectionManager} is a wrapper around {@link FreshBooksConnector } that adds connection management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class FreshBooksConnectorConfigConnectionManagementConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<FreshBooksConnectorConnectionManagementAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManagementConnectionManager<ConnectionManagementConfigFreshBooksConnectorConnectionKey, FreshBooksConnectorConnectionManagementAdapter, Config>
{

    /**
     * 
     */
    private String apiUrl;
    /**
     * 
     */
    private String consumerKey;
    /**
     * 
     */
    private String consumerSecret;
    private int maxTotalConnection;
    private int defaultMaxConnectionPerRoute;
    private String accessTokenIdentifierPrefix;
    private ObjectStore objectStore;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "FreshBooks";
    private final static String MODULE_VERSION = "1.2.0";
    private final static String DEVKIT_VERSION = "3.7.2";
    private final static String DEVKIT_BUILD = "3.7.x.2633.51164b9";
    private final static String MIN_MULE_VERSION = "3.6";

    /**
     * Sets consumerKey
     * 
     * @param value Value to set
     */
    public void setConsumerKey(String value) {
        this.consumerKey = value;
    }

    /**
     * Retrieves consumerKey
     * 
     */
    public String getConsumerKey() {
        return this.consumerKey;
    }

    /**
     * Sets apiUrl
     * 
     * @param value Value to set
     */
    public void setApiUrl(String value) {
        this.apiUrl = value;
    }

    /**
     * Retrieves apiUrl
     * 
     */
    public String getApiUrl() {
        return this.apiUrl;
    }

    /**
     * Sets consumerSecret
     * 
     * @param value Value to set
     */
    public void setConsumerSecret(String value) {
        this.consumerSecret = value;
    }

    /**
     * Retrieves consumerSecret
     * 
     */
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    /**
     * Sets maxTotalConnection
     * 
     * @param value Value to set
     */
    public void setMaxTotalConnection(int value) {
        this.maxTotalConnection = value;
    }

    /**
     * Retrieves maxTotalConnection
     * 
     */
    public int getMaxTotalConnection() {
        return this.maxTotalConnection;
    }

    /**
     * Sets defaultMaxConnectionPerRoute
     * 
     * @param value Value to set
     */
    public void setDefaultMaxConnectionPerRoute(int value) {
        this.defaultMaxConnectionPerRoute = value;
    }

    /**
     * Retrieves defaultMaxConnectionPerRoute
     * 
     */
    public int getDefaultMaxConnectionPerRoute() {
        return this.defaultMaxConnectionPerRoute;
    }

    /**
     * Sets accessTokenIdentifierPrefix
     * 
     * @param value Value to set
     */
    public void setAccessTokenIdentifierPrefix(String value) {
        this.accessTokenIdentifierPrefix = value;
    }

    /**
     * Retrieves accessTokenIdentifierPrefix
     * 
     */
    public String getAccessTokenIdentifierPrefix() {
        return this.accessTokenIdentifierPrefix;
    }

    /**
     * Sets objectStore
     * 
     * @param value Value to set
     */
    public void setObjectStore(ObjectStore value) {
        this.objectStore = value;
    }

    /**
     * Retrieves objectStore
     * 
     */
    public ObjectStore getObjectStore() {
        return this.objectStore;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new ConnectionManagementConnectorFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public FreshBooksConnectorConnectionManagementAdapter acquireConnection(ConnectionManagementConfigFreshBooksConnectorConnectionKey key)
        throws Exception
    {
        return ((FreshBooksConnectorConnectionManagementAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(ConnectionManagementConfigFreshBooksConnectorConnectionKey key, FreshBooksConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(ConnectionManagementConfigFreshBooksConnectorConnectionKey key, FreshBooksConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, FreshBooksConnectorConnectionManagementAdapter> getProcessTemplate() {
        return new ConnectionManagementProcessTemplate(this, muleContext);
    }

    @Override
    public ConnectionManagementConfigFreshBooksConnectorConnectionKey getDefaultConnectionKey() {
        return new ConnectionManagementConfigFreshBooksConnectorConnectionKey(getApiUrl(), getConsumerKey(), getConsumerSecret());
    }

    @Override
    public ConnectionManagementConfigFreshBooksConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedApiUrl = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("apiUrl").getGenericType(), null, getApiUrl()));
            if (_transformedApiUrl == null) {
                throw new UnableToAcquireConnectionException("Parameter apiUrl in method connect can't be null because is not @Optional");
            }
            final String _transformedConsumerKey = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("consumerKey").getGenericType(), null, getConsumerKey()));
            if (_transformedConsumerKey == null) {
                throw new UnableToAcquireConnectionException("Parameter consumerKey in method connect can't be null because is not @Optional");
            }
            final String _transformedConsumerSecret = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("consumerSecret").getGenericType(), null, getConsumerSecret()));
            if (_transformedConsumerSecret == null) {
                throw new UnableToAcquireConnectionException("Parameter consumerSecret in method connect can't be null because is not @Optional");
            }
            return new ConnectionManagementConfigFreshBooksConnectorConnectionKey(_transformedApiUrl, _transformedConsumerKey, _transformedConsumerSecret);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    @Override
    public ConnectionManagementConfigFreshBooksConnectorConnectionKey getConnectionKey(MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return getEvaluatedConnectionKey(event);
    }

    @Override
    public ConnectionManagementConnectionAdapter newConnection() {
        ConfigFreshBooksConnectorAdapter connection = new ConfigFreshBooksConnectorAdapter();
        connection.setMaxTotalConnection(getMaxTotalConnection());
        connection.setDefaultMaxConnectionPerRoute(getDefaultMaxConnectionPerRoute());
        connection.setAccessTokenIdentifierPrefix(getAccessTokenIdentifierPrefix());
        connection.setObjectStore(getObjectStore());
        return connection;
    }

    @Override
    public ConnectionManagementConnectorAdapter newConnector(ConnectionManagementConnectionAdapter<Config, ConnectionManagementConfigFreshBooksConnectorConnectionKey> connection) {
        FreshBooksConnectorConnectionManagementAdapter connector = new FreshBooksConnectorConnectionManagementAdapter();
        connector.setConfig(connection.getStrategy());
        return connector;
    }

    public ConnectionManagementConnectionAdapter getConnectionAdapter(ConnectionManagementConnectorAdapter adapter) {
        FreshBooksConnectorConnectionManagementAdapter connector = ((FreshBooksConnectorConnectionManagementAdapter) adapter);
        ConnectionManagementConnectionAdapter strategy = ((ConnectionManagementConnectionAdapter) connector.getConfig());
        return strategy;
    }

    public TestResult test() {
        try {
            ConfigFreshBooksConnectorAdapter strategy = ((ConfigFreshBooksConnectorAdapter) newConnection());
            MuleContextAwareManager.setMuleContext(strategy, this.muleContext);
            LifeCycleManager.executeInitialiseAndStart(strategy);
            ConnectionManagementConnectorAdapter connectorAdapter = newConnector(strategy);
            MuleContextAwareManager.setMuleContext(connectorAdapter, this.muleContext);
            LifeCycleManager.executeInitialiseAndStart(connectorAdapter);
            strategy.test(getDefaultConnectionKey());
            return new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (Exception e) {
            return ((DefaultTestResult) ConnectivityTestingErrorHandler.buildFailureTestResult(e));
        }
    }

}
