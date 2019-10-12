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
            // if logged in
            List<Property> pl = new ArrayList<>();
            if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                // if user is agent type, get property list
                pl = PropertyManagement.viewMyPropertyList(AppSession.getUser().getId());
            } else if (AppSession.hasRole(AppSession.CLIENT_ROLE)) {
                // if user is client type, get favorite list of properties
                pl = PropertyManagement.getMyFavoriteList(AppSession.getUser().getId());
            }
            // update the property_list in AppSession
            AppSession.setPropertyList(pl);
            forward("/property-list.jsp");
        }
        else {
            // ask the user to log in
            FlashMessage.createAlertMessage("You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
