package commands;

import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        FlashMessage.createErrorMessage(request.getSession(), "System error, unknown command.");
        forward("/index.jsp");
    }
}
