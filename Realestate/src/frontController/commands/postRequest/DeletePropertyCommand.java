package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import models.Property;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Post: delete a property Command
 */
public class DeletePropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            User user = AppSession.getUser();
            if (request.getParameter("property-id") != null) {
                try {
                    int property_id = Integer.parseInt(request.getParameter("property-id"));
                    PropertyManagement.deleteProperty(property_id);
                    FlashMessage.createSuccessMessage(request.getSession(), "Property has been deleted.");
                } catch (SQLException e) {
                    // exception is caught during the deleteProperty procedure
                    FlashMessage.createErrorMessage(request.getSession(), "Fail to delete the property.");
                }
            } else {
                // id is missing, cannot delete the chosen property
                FlashMessage.createErrorMessage(request.getSession(), "Fail to delete the property.");
            }

            List<Property> pl = PropertyManagement.viewMyPropertyList(user.getId());
            request.getSession().setAttribute("propertyList", pl);
            forward("/property-list.jsp");
        } else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
