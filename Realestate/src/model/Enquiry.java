package model;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct object based on information retrieved from enquiries table in database
 */

public class Enquiry {
    private int id;
    private Client client;
    private Property property;
    private String clientEnquiry;
    private String agentResponse;

    public Enquiry(int id, Client client, Property property) {
        this.id = id;
        this.client = client;
        this.property = property;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getClientEnquiry() {
        return clientEnquiry;
    }

    public void setClientEnquiry(String clientEnquiry) {
        this.clientEnquiry = clientEnquiry;
    }

    public String getAgentResponse() {
        return agentResponse;
    }

    public void setAgentResponse(String agentResponse) {
        this.agentResponse = agentResponse;
    }
}
