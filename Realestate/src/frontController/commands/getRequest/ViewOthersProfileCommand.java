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
        int agent_id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : -1;
//        User otherUser = UserManagement.getUserBasedOnID(id);
        AgentDTO otherUser = AgentFacade.getInstance().getAgentDTO(agent_id);
        AppSession.setOtherUser(otherUser);

        List<Property> pl = PropertyManagement.viewMyPropertyList(agent_id);
        AppSession.setPropertyList(pl);
        forward("/profile-others.jsp");
    }
}