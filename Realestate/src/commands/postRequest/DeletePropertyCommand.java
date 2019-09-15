package commands.postRequest;

import commands.FrontCommand;
import domainLogic.PropertyManagement;
import models.Property;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Post: delete a property Command
 */
public class DeletePropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (request.getParameter("property-id") != null && request.getParameter("address-id") != null) {
                int property_id = Integer.parseInt(request.getParameter("property-id"));
                int address_id = Integer.parseInt(request.getParameter("address-id"));
                if (PropertyManagement.deleteProperty(user.getId(), property_id, address_id)) {
                    FlashMessage.createSuccessMessage(request.getSession(), "Property has been deleted.");
                }
            }
            else {
                FlashMessage.createErrorMessage(request.getSession(), "Fail to delete the property.");
            }

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
