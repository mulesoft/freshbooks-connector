package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class ClientRequest extends BaseRequest {
    
    @XmlElement(name = "client_id")
    private String clientId;
    @XmlElement
    private Client client;
    @XmlElement
    private String email;
    @XmlElement
    private String username;
//    <!-- Return only clients modified since this date (Optional) -->  
//    <updated_from>2009-01-01 00:00:00</updated_from>  
//    <!-- Return only clients modified before this date (Optional) -->  
//    <updated_to>2009-12-01 00:00:00</updated_to>  
    @XmlElement
    private String notes;
    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
