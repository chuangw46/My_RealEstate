package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import models.Property;
import service.AppSession;
import service.DTO.AgentDTO;
import service.PropertyManagement;
import service.remoteFacade.AgentFacade;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Get Profile Page Command
 */
public class ViewOthersProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // retrieve agent id
        int agent_id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : -1;
        // get agent DTO from AgentFacade
        AgentDTO otherUser = AgentFacade.getInstance().getAgentDTO(agent_id);
        // set agent DTO in session
        AppSession.setOtherUser(otherUser);

        // get property list under this agent through service layer
        List<Property> pl = PropertyManagement.viewMyPropertyList(agent_id);
        // set property list in session
        AppSession.setPropertyList(pl);
        forward("/profile-others.jsp");
    }
}