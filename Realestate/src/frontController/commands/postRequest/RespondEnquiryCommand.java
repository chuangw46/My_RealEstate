package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Post: respond an enquiry Command
 */
public class RespondEnquiryCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        FlashMessage.createSuccessMessage(request.getSession(), "The enquiry has been responded.");
        forward("/enquiry-list.jsp");
    }
}
