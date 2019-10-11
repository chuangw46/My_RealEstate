package frontController.commands.postRequest;

import dataSourceLayer.ConcurrencyUtil.LockerManager;
import frontController.commands.FrontCommand;
import models.Address;
import models.Property;
import service.AppSession;
import service.PropertyManagement;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
        String postal_code = request.getParameter("post-code");
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

        Address address = new Address(street, city, state, Integer.parseInt(postal_code), country);
        if (action.equals("Publish")) {
            // if the action is 'publish'
            try {
                Property property = new Property(type, Integer.parseInt(num_bed), Integer.parseInt(num_bath),
                        Integer.parseInt(num_carpark), Date.valueOf(date_available), Date.valueOf(date_inspection),
                        description, rent_or_buy, Integer.parseInt(price), Integer.parseInt(agent_id));

                // insert the property into db, return true or false
                PropertyManagement.publishProperty(property, address);

                // if success, redirect to property list page
                FlashMessage.createSuccessMessage("Property has been published.");

                // update the property_list in AppSession
                List<Property> pl = PropertyManagement.viewMyPropertyList(Integer.parseInt(agent_id));
                AppSession.setPropertyList(pl);
                forward("/property-list.jsp");
            } catch (SQLException e) {
                FlashMessage.createErrorMessage("Fail to publish the property.");
                forward("/property-publish.jsp");
            }
        } else {
            // if the action is 'edit'
            try {
                // get the old property first from session
                Property property = AppSession.getProperty();

                // update new info
                property.setType(type);
                property.setNum_bed(Integer.parseInt(num_bed));
                property.setNum_bath(Integer.parseInt(num_bath));
                property.setNum_carpark(Integer.parseInt(num_carpark));
                property.setDate_available(Date.valueOf(date_available));
                property.setDate_inspection(Date.valueOf(date_inspection));
                property.setDescription(description);
                property.retrieveTheAddressObj().setStreet(street);
                property.retrieveTheAddressObj().setCity(city);
                property.retrieveTheAddressObj().setState(state);
                property.retrieveTheAddressObj().setPostal_code(Integer.parseInt(postal_code));
                property.retrieveTheAddressObj().setCountry(country);
                property.setRent_or_buy(rent_or_buy);
                property.setPrice(Integer.parseInt(price));

                // update db -> get the updated property
                PropertyManagement.updateProperty(property);

                // give flash msg on the web interface
                FlashMessage.createSuccessMessage("Property has been updated.");

                // if the update is successful, update the currentProperty in AppSession
                AppSession.setProperty(property);

                // release the lock for the business transaction which contains READ from db
                LockerManager.getInstance().releaseLock(property, AppSession.getSessionId());
                forward("/property-info.jsp");
            } catch (SQLException e) {
                // if the update fails, prompt error
                FlashMessage.createErrorMessage("Fail to update property details.");
                forward("/property-edit.jsp");
            }
        }

    }
}
