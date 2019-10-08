package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import models.Property;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Get List of Properties Page Command
 */
public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            List<Property> pl = PropertyManagement.viewMyPropertyList(AppSession.getUser().getId());
            request.getSession().setAttribute("propertyList", pl);
            forward("/property-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
