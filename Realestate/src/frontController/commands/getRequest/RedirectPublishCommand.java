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
            if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                if (AppSession.getProperty() != null)
                    // remove the property in AppSession
                    AppSession.removeProperty();
                forward("/property-publish.jsp");
            }
            else {
                FlashMessage.createAlertMessage(request.getSession(),
                        "Only agents can publish properties or update property details.");
                forward("/index.jsp");
            }
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
