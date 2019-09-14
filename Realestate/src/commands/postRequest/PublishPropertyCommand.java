package commands.postRequest;

import commands.FrontCommand;
import models.Property;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Post: publish a property Command
 */
public class PublishPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        FlashMessage.createSuccessMessage(request.getSession(), "Property has been published.");
        Property p1 = new Property(1, "House", 3, 2, 1, new Date(1), new Date(1), "XXX", 1, "Rent", 350, 1);
        List<Property> p = new ArrayList<>();
        p.add(p1);
        request.getSession().setAttribute("propertyList", p);
        forward("/property-list.jsp");
    }
}
