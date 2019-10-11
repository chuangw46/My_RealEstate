package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class UnlikePropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // get property id that is being unliked
        int property_id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : -1;
        try {
            // unlike the property through service layer method
            PropertyManagement.unlikeAProperty(AppSession.getUser().getId(), property_id);
            // set is_like to false after unlike action
            AppSession.setLikeProperty(false);
            forward("/property-info.jsp");
        } catch (SQLException e) {
            FlashMessage.createErrorMessage("Fail to like the property, please try again later.");
            forward("/property-info.jsp");
        }
    }
}
