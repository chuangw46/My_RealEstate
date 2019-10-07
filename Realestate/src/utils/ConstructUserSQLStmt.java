package utils;

import model.Agent;
import model.Client;
import model.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct sql statement for client or agent table
 */
public class ConstructUserSQLStmt {
    public static String getClientSELECTStmt(String email) {
        return "SELECT * FROM client WHERE email = '" + email + "'";
    }

    public static String getAgentSELECTStmt(String email) {
        return "SELECT * FROM agent WHERE email = '" + email + "'";
    }

    public static String getClientINSERTStmt(User client){
        return "INSERT INTO client " +
                        "(email, " +
                        "password, " +
                        "name)\n" +
                "VALUES ('" +
                        client.getEmail() + "', '" +
                        client.getPassword() + "', '" +
                        client.getName()+ "');";
    }

    public static String getAgentINSERTStmt(User agent){
        return "INSERT INTO agent " +
                "(email, " +
                "password, " +
                "name)\n" +
                "VALUES ('" +
                agent.getEmail() + "', '" +
                agent.getPassword() + "', '" +
                agent.getName()+ "');";

    }


    public static String getClientUPDATEStmt(Client client) {
        return "UPDATE client\n" +
                "SET email = '" + client.getEmail() + "', " +
                        "password = '" + client.getPassword() + "', " +
                        "name = '" + client.getName() + "'\n" +
                "WHERE client_id = " + client.getId() + ";" ;
    }

    public static String getAgentUPDATEStmt(Agent agent) {
        return "UPDATE agent\n" +
                "SET email = '" + agent.getEmail() + "', " +
                        "password = '" + agent.getPassword() + "', " +
                        "name = '" + agent.getName() + "', " +
                        "phone = '" + agent.getPhone() + "', " +
                        "company_name = '" + agent.getCompany().getName() + "', " +
                        "company_address = '" + agent.getCompany().getAddress() + "', " +
                        "company_website = '" + agent.getCompany().getWebsite() + "', " +
                        "bio = '" + agent.getBio() + "' \n" +
                "WHERE agent_id = " + agent.getId() + ";" ;
    }
}
