package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;

public class ClientResponse extends BaseResponse {

    @XmlElement(name = "client_id", nillable=true)
    private String clientId;
    @XmlElement(name = "client", required = false)
    private Client client;
    @XmlElement(name = "clients", required = false)
    private Clients clients;

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

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }
}
