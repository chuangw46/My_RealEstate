package service.remoteFacade;

import dataSourceLayer.mappers.userMapper.UserMapper;
import models.Agent;
import service.DTO.AgentDTO;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class AgentFacade {
    private static AgentFacade instance;
    private AgentFacade() {}
    public static AgentFacade getInstance() {
        if (instance == null){
            instance = new AgentFacade();
        }
        return instance;
    }
    public AgentDTO getAgentDTO(int agentID){
        Agent agent = (Agent) UserMapper.getSelfInstance().getAgentByID(agentID);
        return AgentAssembler.createAgentDTO(agent);
    }

    public void updateAgent(AgentDTO agentDTO) throws SQLException {
        AgentAssembler.updateAgent(agentDTO);
    }

    public String getAgentJSON(int agentID) {
        return AgentDTO.serialize(getAgentDTO(agentID));
    }

    public void updateAgentJSON(String json) throws SQLException {
        updateAgent(AgentDTO.deserialize(json));
    }
}
