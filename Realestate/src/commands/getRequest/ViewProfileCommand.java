package commands.getRequest;

import commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Profile Page Command
 */
public class ViewProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getSession().getAttribute("currentUser") != null) {
            forward("/profile.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in");
            forward("/signin.jsp");
        }
    }
}
