package commands.getRequest;

import commands.FrontCommand;
import models.Address;
import models.Property;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;

/**
 * Get Edit Property Details Page Command
 */
public class RedirectEditPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int p_id = Integer.parseInt(request.getParameter("id"));
            Property p1 = new Property(1, "House", 3, 2, 1, new Date(1), new Date(1), "XXX", 1, "Rent", 350, 1);
            Address a = new Address(1, "303 Canning St.", "Carlton", "VIC", 3053, "AU");
            request.getSession().setAttribute("currentProperty", p1);
            request.getSession().setAttribute("currentAddress", a);
        }
        forward("/property-edit.jsp");
    }
}
