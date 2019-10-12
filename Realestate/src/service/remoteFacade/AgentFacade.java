package service.remoteFacade;

import dataSourceLayer.mappers.userMapper.UserMapper;
import models.Agent;
import service.DTO.AgentAssembler;
import service.DTO.AgentDTO;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class AgentFacade {
    //---------------------------- singleton pattern setup ---------------------------------------
    private static AgentFacade instance;
    private static AgentAssembler agentAssembler = new AgentAssembler();
    private AgentFacade() {}
    public static AgentFacade getInstance() {
        if (instance == null){
            instance = new AgentFacade();
        }
        return instance;
    }

    /**
     * generate an agent DTO based on given agent ID
     * @param agentID
     * @return agent DTO object
     */
    public AgentDTO getAgentDTO(int agentID){
        Agent agent = (Agent) UserMapper.getSelfInstance().getAgentByID(agentID);
        return agentAssembler.createAgentDTO(agent);
    }

    /**
     * update an agent data based on an agent dto object and store it into database
     * @param agentDTO
     * @throws SQLException
     */
    public void updateAgent(AgentDTO agentDTO) throws SQLException {
        agentAssembler.updateAgent(agentDTO);
    }

    // serialize
    public String getAgentJSON(int agentID) {
        return AgentDTO.serialize(getAgentDTO(agentID));
    }

    // deserialize
    public void updateAgentJSON(String json) throws SQLException {
        updateAgent(AgentDTO.deserialize(json));
    }

    /**
     * get an agent assembler object
     * @return AgentAssembler object
     */
    public static AgentAssembler getAgentAssembler() {
        return agentAssembler;
    }
}
