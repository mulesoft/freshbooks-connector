package org.mule.modules.freshbooks.model;


public class ClientResponse extends BaseResponse {

    private String clientId;
    private Client client;
    private Clients clients;

    public ClientResponse(Response response) {
        initBaseResponseFields(response);
        clientId = response.getClientId();
        client = response.getClient();
        clients = response.getClients();
    }
    
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
