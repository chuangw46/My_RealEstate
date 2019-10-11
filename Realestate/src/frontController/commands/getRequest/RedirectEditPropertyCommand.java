package frontController.commands.getRequest;

import dataSourceLayer.ConcurrencyUtil.LockerManager;
import frontController.commands.FrontCommand;
import models.Property;
import service.AppSession;
import service.PropertyManagement;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Edit Property Details Page Command
 */
public class RedirectEditPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int property_id = Integer.parseInt(request.getParameter("id"));
            Property property = new Property(property_id);

            // Lock the business transaction which contains READ from db
            LockerManager.getInstance().acquireLock(property, AppSession.getSessionId());

            property = PropertyManagement.viewSpecificProperty(property_id);
            // update property in AppSession
            AppSession.setProperty(property);
        }
        forward("/property-edit.jsp");
    }
}
