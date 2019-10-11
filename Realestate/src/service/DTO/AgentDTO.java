package service.DTO;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class AgentDTO implements Serializable {
    private int agent_id;
    private String agent_name;
    private String agent_email;
    private String agent_password;
    private String agent_phone;
    private String agent_bio;

    private String company_name;
    private String company_address;
    private String company_website;


//    public AgentDTO(int agent_id, String agent_phone, String agent_bio, String company_name, String company_address, String company_website) {
//        this.agent_id = agent_id;
//        this.agent_phone = agent_phone;
//        this.agent_bio = agent_bio;
//        this.company_name = company_name;
//        this.company_address = company_address;
//        this.company_website = company_website;
//    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_email() {
        return agent_email;
    }

    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }

    public String getAgent_password() {
        return agent_password;
    }

    public void setAgent_password(String agent_password) {
        this.agent_password = agent_password;
    }

    public String getAgent_phone() {
        return agent_phone;
    }

    public void setAgent_phone(String agent_phone) {
        this.agent_phone = agent_phone;
    }

    public String getAgent_bio() {
        return agent_bio;
    }

    public void setAgent_bio(String agent_bio) {
        this.agent_bio = agent_bio;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public static String serialize(AgentDTO agentDTO) {
        Gson gson = new Gson();
        return gson.toJson(agentDTO);
    }

    public static AgentDTO deserialize(String agentDTOStr){
        Gson gson = new Gson();
        return gson.fromJson(agentDTOStr, AgentDTO.class);
    }
}
