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
            forward("/profile.jsp");
        } else {
            FlashMessage.createAlertMessage("You are required to sign in");
            forward("/signin.jsp");
        }
    }
}
