package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import service.PropertyManagement;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class LikePropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // get property id that is being liked
        int property_id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : -1;
        try {
            // like the property through service layer method
            PropertyManagement.likeAProperty(AppSession.getUser().getId(), property_id);
            System.out.println("----------------" + AppSession.getUser().getId() + "----" );
            // set is_like to true after like action
            AppSession.setLikeProperty(true);
            forward("/property-info.jsp");
        } catch (SQLException e) {
            FlashMessage.createErrorMessage("Fail to like the property, please try again later.");
            forward("/property-info.jsp");
        }
    }
}
