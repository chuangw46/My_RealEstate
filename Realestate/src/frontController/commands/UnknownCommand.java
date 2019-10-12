package frontController.commands;

import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // send unknown command message to the web pages
        FlashMessage.createErrorMessage("System error, unknown command.");
        forward("/index.jsp");
    }
}
