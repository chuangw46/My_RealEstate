package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
import service.PropertyManagement;
import models.Property;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Post: publish a property Command
 */
public class PublishPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {

        // retrieve all form's parameters in post request
        String action = request.getParameter("action");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        int postal_code = Integer.parseInt(request.getParameter("post-code"));
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String rent_or_buy = request.getParameter("rent-sell");
        String num_bed = request.getParameter("bed-num");
        String num_bath = request.getParameter("bath-num");
        String num_carpark = request.getParameter("car-park-num");
        String date_inspection = request.getParameter("inspection-date");
        String date_available = request.getParameter("available-date");
        String description = request.getParameter("description");
        String agent_id = request.getParameter("id");

        if (action.equals("Publish")) {
            // insert the property into db, return true or false
            boolean success = PropertyManagement.publishProperty(type, num_bed, num_bath, num_carpark,
                    date_available, date_inspection, description, street, city, state, postal_code, country, rent_or_buy
                    , price, agent_id);
            if (success) {
                // if success, redirect to property list page
                FlashMessage.createSuccessMessage(request.getSession(), "Property has been published.");

                //
                List<Property> pl = PropertyManagement.viewMyPropertyList(Integer.parseInt(agent_id));
                request.getSession().setAttribute("propertyList", pl);
                forward("/property-list.jsp");
            }
        } else {
            // if the action is 'edit'

            // get the old property first
            Property old_property = (Property) request.getSession().getAttribute("currentProperty");

            // update db -> get the updated property
            Property new_property = PropertyManagement.updateProperty(old_property, type, num_bed,
                    num_bath, num_carpark,
                    date_available, date_inspection, description, street, city, state, postal_code, country, rent_or_buy
                    , price);

            // if the update is successful
            if (new_property != null) {
                // give flash msg on the web interface
                FlashMessage.createSuccessMessage(request.getSession(), "Property has been " +
                        "updated.");
                request.getSession().setAttribute("propertyList", new_property);
                forward("/property-info.jsp");
            }
            else {
                // if the update fails, prompt error
                FlashMessage.createErrorMessage(request.getSession(), "Fail to update property " +
                        "details.");
                forward("/property-edit.jsp");
            }

        }

    }
}
