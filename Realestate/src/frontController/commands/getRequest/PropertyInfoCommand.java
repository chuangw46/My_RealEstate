package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import models.User;
import service.AppSession;
import service.PropertyManagement;
import models.Property;

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
            Property p = PropertyManagement.viewSpecificProperty(property_id);
            // update the property in AppSession
            AppSession.setProperty(p);
            User agent = p.retrieveTheAgentObj();
            AppSession.setOtherUser(agent);
            if (AppSession.isAuthenticated() && AppSession.hasRole(AppSession.CLIENT_ROLE)) {
                boolean is_liked = PropertyManagement.isPropertyBeingLiked(AppSession.getUser().getId(), p.getId());
                AppSession.setLikeProperty(is_liked);
            }
        }
        forward("/property-info.jsp");
    }
}
