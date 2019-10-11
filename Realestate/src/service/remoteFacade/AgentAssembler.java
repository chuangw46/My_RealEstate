package service.remoteFacade;

import dataSourceLayer.mappers.userMapper.UserMapper;
import models.AgencyCompany;
import models.Agent;
import service.DTO.AgentDTO;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class AgentAssembler {
    public static AgentDTO createAgentDTO(Agent agent) {
        AgentDTO result = new AgentDTO();

        // collect all agent fields
        int agent_id = agent.getId();
        String name = agent.getName();
        String email = agent.getEmail();
        String password = agent.getPassword();
        String phone = agent.getPhone();
        String bio = agent.getBio();

        // collect all company fields
        AgencyCompany company = agent.getCompany();
        String company_name = company.getName();
        String company_address = company.getAddress();
        String company_website = company.getWebsite();

        // assemble AgentDTO object
        result.setAgent_name(name);
        result.setAgent_email(email);
        result.setAgent_password(password);
        result.setAgent_id(agent_id);
        result.setAgent_phone(phone);
        result.setAgent_bio(bio);
        result.setCompany_name(company_name);
        result.setCompany_address(company_address);
        result.setCompany_website(company_website);

        return result;
    }

    public static void updateAgent(AgentDTO agentDTO) throws SQLException {
        Agent agent = new Agent();
        agent.setName(agentDTO.getAgent_name());
        agent.setEmail(agentDTO.getAgent_email());
        agent.setPassword(agentDTO.getAgent_password());
        agent.setId(agentDTO.getAgent_id());
        agent.setPhone(agentDTO.getAgent_phone());
        agent.setBio(agentDTO.getAgent_bio());

        AgencyCompany company = new AgencyCompany();
        company.setName(agentDTO.getCompany_name());
        company.setAddress(agentDTO.getCompany_address());
        company.setWebsite(agentDTO.getCompany_website());

        agent.setCompany(company);
        UserMapper.getLockingMapperInstance().update(agent);
    }
}
