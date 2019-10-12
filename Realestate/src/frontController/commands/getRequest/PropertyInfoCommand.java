package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import models.Property;
import service.AppSession;
import service.DTO.AgentDTO;
import service.PropertyManagement;
import service.remoteFacade.AgentFacade;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Property Information Page Command
 */
public class PropertyInfoCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // try to get property id
        if (request.getParameter("id") != null) {
            int property_id = Integer.parseInt(request.getParameter("id"));

            // build a property object based on data retried from db
            Property property = PropertyManagement.viewSpecificProperty(property_id);
            // update the property in AppSession
            AppSession.setProperty(property);
//            User agent = property.retrieveTheAgentObj();
            AgentDTO agentDTO = AgentFacade.getInstance().getAgentDTO(property.getAgent_id());
            AppSession.setOtherUser(agentDTO);
            if (AppSession.isAuthenticated() && AppSession.hasRole(AppSession.CLIENT_ROLE)) {
                boolean is_liked = PropertyManagement.isPropertyBeingLiked(AppSession.getUser().getId(), property.getId());
                AppSession.setLikeProperty(is_liked);
            }
        }
        forward("/property-info.jsp");
    }
}
