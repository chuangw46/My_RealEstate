package frontController.commands.getRequest;

import frontController.commands.FrontCommand;
import service.AppSession;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get List of Enquiries Page Command
 */
public class ViewEnquiryCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (AppSession.isAuthenticated()) {
            forward("/enquiry-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
