package commands.getRequest;

import commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Publish Property Page Command
 */
public class RedirectPublishCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getSession().getAttribute("currentUser") != null) {
            if (request.getSession().getAttribute("userType").equals("Agent")) {
                if (request.getSession().getAttribute("currentProperty") != null)
                    request.getSession().removeAttribute("currentProperty");
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
