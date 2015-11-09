package org.mule.modules.freshbooks;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.config.MuleProperties;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.freshbooks.api.DefaultFreshBooksClient;
import org.mule.modules.freshbooks.api.FreshBooksClient;
import org.mule.modules.freshbooks.api.ObjectStoreHelper;
import org.mule.modules.freshbooks.exception.FreshBooksException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConnectionManagement(configElementName = "config", friendlyName = "Configuration")
public class Config {
    
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    
    private DefaultFreshBooksClient client;

    /**
     * Prefix used for storing credentials in ObjectStore. It will be concatenated to the access token identifier.
     * <p>E.g. prefix: "fb_", user identifier: "12345", key for object store "fb_12345"</p>
     */
    @Configurable
    @Optional
    private String accessTokenIdentifierPrefix;
    
    /**
     * Object store reference
     */
    @Configurable
    @Default(MuleProperties.DEFAULT_USER_OBJECT_STORE_NAME)
    private ObjectStore objectStore;
    
    /**
     * Object store helper
     */
    private ObjectStoreHelper objectStoreHelper;
        
    /**
     * Constructs a new {@link Config} Instance with default configuration values set to false.
     */
    public Config() {   }
    
    
    public String getConsumerKey(){
        return ((DefaultFreshBooksClient) getClient()).getApiKey();
    }
    
    public String getConsumerSecret(){
        return ((DefaultFreshBooksClient) getClient()).getApiSecret();
    }
    
    public DefaultFreshBooksClient getClient() {
        return client;
    }

    public void setClient(DefaultFreshBooksClient client) {
        this.client = client;
    }

    public ObjectStore getObjectStore() {
        return objectStore;
    }

    public void setObjectStore(ObjectStore objectStore) {
        this.objectStore = objectStore;
    }

    public ObjectStoreHelper getObjectStoreHelper() {
        return objectStoreHelper;
    }

    public void setObjectStoreHelper(ObjectStoreHelper objectStoreHelper) {
        this.objectStoreHelper = objectStoreHelper;
    }

    public String getAccessTokenIdentifierPrefix() {
        return accessTokenIdentifierPrefix;
    }

    public void setAccessTokenIdentifierPrefix(String accessTokenIdentifierPrefix) {
        this.accessTokenIdentifierPrefix = accessTokenIdentifierPrefix;
    }
    
    /**
     * Connect to a FreshBooks client
     * @throws ConnectionException when the connection process failed
     */
    @Connect
    @TestConnectivity(active = false)
    public void connect(@ConnectionKey String apiUrl,  String authorizationToken,
            int maxTotalConnection, int defaultMaxConnectionPerRoute) throws ConnectionException {

        logger.debug("Establishing connection with FreshBooks...");
        
        setClient(new DefaultFreshBooksClient(apiUrl, authorizationToken, maxTotalConnection,
                defaultMaxConnectionPerRoute));
        
        setObjectStoreHelper(new ObjectStoreHelper(objectStore));
        
        
        logger.debug("Session created");
    }

    
    /**
     * Clear the current connection and resources
     */
    @Disconnect
    public void disconnect() {
        if (objectStore != null) {
            this.objectStore = null;
        }
    }
    
    /**
     * Validate is active connection
     */
    @ValidateConnection
    public boolean isConnected() {
        return objectStore != null;
    }
        
    /**
     * Returns the beginning of the tenant key identifier
     *
     * @return String with the first part of the key
     */
    @ConnectionIdentifier
    public String connectionIdentifier() {
        return "freshbooks-";
    }
   
}
