package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import models.Property;
import service.AppSession;
import service.PropertyManagement;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Get Search Property Page Command
 */
public class SearchPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // get parameters from the form of GET method
        String rent_or_buy = request.getParameter("rent-or-buy");
        String type = request.getParameter("type");

        // -1 refers to no user input in this filter
        int maxBeds = !request.getParameter("max-beds").equals("") ?
                Integer.parseInt(request.getParameter("max-beds")) : -1;
        int minBeds = !request.getParameter("min-beds").equals("") ?
                Integer.parseInt(request.getParameter("min-beds")) : -1;
        int maxPrice = !request.getParameter("max-price").equals("") ?
                Integer.parseInt(request.getParameter("max-price")) : -1;
        int minPrice = !request.getParameter("min-price").equals("") ?
                Integer.parseInt(request.getParameter("min-price")) : -1;
        int postCode = !request.getParameter("postal-code").equals("") ?
                Integer.parseInt(request.getParameter("postal-code")) : -1;

        // update property list in the AppSession
        List<Property> pl = PropertyManagement.searchPropertyByFilters(rent_or_buy, type, minBeds, maxBeds, minPrice,
                maxPrice, postCode);
        AppSession.setPropertyList(pl);
        forward("/property-results.jsp");
    }
}
