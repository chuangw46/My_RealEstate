package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Profile Page Command
 */
public class ViewProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            // if logged in, go to profile page
            forward("/profile.jsp");
        } else {
            // ask the user to log in
            FlashMessage.createAlertMessage("You are required to sign in");
            forward("/signin.jsp");
        }
    }
}
