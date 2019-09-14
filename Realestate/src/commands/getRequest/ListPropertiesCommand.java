package commands.getRequest;

import commands.FrontCommand;
import models.Property;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Get List of Properties Page Command
 */
public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        Property p1 = new Property(1, "House", 3, 2, 1, new Date(1), new Date(1), "XXX", 1, "rent", 350, 1);
        List<Property> p = new ArrayList<>();
        p.add(p1);
        request.getSession().setAttribute("propertyList", p);
        if (request.getSession().getAttribute("currentUser") != null) {
            forward("/property-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
