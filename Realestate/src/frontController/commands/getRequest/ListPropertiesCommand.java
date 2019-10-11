package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import models.Property;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Get List of Properties Page Command
 */
public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            List<Property> pl = new ArrayList<>();
            if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                pl = PropertyManagement.viewMyPropertyList(AppSession.getUser().getId());
            } else if (AppSession.hasRole(AppSession.CLIENT_ROLE)) {
                pl = PropertyManagement.getMyFavoriteList(AppSession.getUser().getId());
            }
            // update the property_list in AppSession
            AppSession.setPropertyList(pl);
            forward("/property-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage("You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
