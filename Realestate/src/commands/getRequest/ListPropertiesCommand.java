package commands.getRequest;

import commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getSession().getAttribute("currentUser") != null) {
            forward("/property-list.jsp");
        }
        else {
            FlashMessage.createAlertMessage(request.getSession(), "You are required to sign in.");
            forward("/signin.jsp");
        }
    }
}
