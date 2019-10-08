package commands.getRequest;

import commands.FrontCommand;
import service.PropertyManagement;
import models.Property;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Get List of Properties Page Command
 */
public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            List<Property> pl = PropertyManagement.viewMyPropertyList(user.getId());
            request.getSession().setAttribute("propertyList", pl);
            forward("/property-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
