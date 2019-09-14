package commands.postRequest;

import commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Post: delete a property Command
 */
public class DeletePropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        FlashMessage.createSuccessMessage(request.getSession(), "Property has been deleted.");
        forward("/property-list.jsp");
    }
}
