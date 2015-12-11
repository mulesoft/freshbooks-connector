
package org.mule.modules.freshbooks.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionKey;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class ConnectionManagementConfigFreshBooksConnectorConnectionKey implements ConnectionManagementConnectionKey
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

    public ConnectionManagementConfigFreshBooksConnectorConnectionKey(String apiUrl, String consumerKey, String consumerSecret) {
        this.apiUrl = apiUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

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

    @Override
    public int hashCode() {
        int result = ((this.apiUrl!= null)?this.apiUrl.hashCode(): 0);
        result = ((31 *result)+((this.consumerKey!= null)?this.consumerKey.hashCode(): 0));
        result = ((31 *result)+((this.consumerSecret!= null)?this.consumerSecret.hashCode(): 0));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionManagementConfigFreshBooksConnectorConnectionKey)) {
            return false;
        }
        ConnectionManagementConfigFreshBooksConnectorConnectionKey that = ((ConnectionManagementConfigFreshBooksConnectorConnectionKey) o);
        if (((this.apiUrl!= null)?(!this.apiUrl.equals(that.apiUrl)):(that.apiUrl!= null))) {
            return false;
        }
        if (((this.consumerKey!= null)?(!this.consumerKey.equals(that.consumerKey)):(that.consumerKey!= null))) {
            return false;
        }
        if (((this.consumerSecret!= null)?(!this.consumerSecret.equals(that.consumerSecret)):(that.consumerSecret!= null))) {
            return false;
        }
        return true;
    }

}
