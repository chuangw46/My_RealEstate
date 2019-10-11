package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import models.Property;
import models.User;
import service.AppSession;
import service.PropertyManagement;
import service.UserManagement;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Get Profile Page Command
 */
public class ViewOthersProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : -1;
        User otherUser = UserManagement.getUserBasedOnID(id);
        AppSession.setOtherUser(otherUser);

        List<Property> pl = PropertyManagement.viewMyPropertyList(id);
        AppSession.setPropertyList(pl);
        forward("/profile-others.jsp");
    }
}