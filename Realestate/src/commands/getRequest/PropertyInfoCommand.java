package commands.getRequest;

import commands.FrontCommand;
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
            if (p != null)
                request.getSession().setAttribute("currentProperty", p);
        }
        forward("/property-info.jsp");
    }
}
