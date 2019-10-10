package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import models.Property;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Edit Property Details Page Command
 */
public class RedirectEditPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int property_id = Integer.parseInt(request.getParameter("id"));
            Property p = PropertyManagement.viewSpecificProperty(property_id);
            // update property in AppSession
            AppSession.setProperty(p);
        }
        forward("/property-edit.jsp");
    }
}
