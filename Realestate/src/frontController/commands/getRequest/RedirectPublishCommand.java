package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Publish Property Page Command
 */
public class RedirectPublishCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            // if logged in
            if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                // if current user is agent type
                if (AppSession.getProperty() != null)
                    // remove the property in AppSession
                    AppSession.removeProperty();
                forward("/property-publish.jsp");
            }
            else {
                // user is client type, no authorisation
                FlashMessage.createAlertMessage("Only agents can publish properties or update property details.");
                forward("/index.jsp");
            }
        }
        else {
            // ask the user to log in
            FlashMessage.createAlertMessage("You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
