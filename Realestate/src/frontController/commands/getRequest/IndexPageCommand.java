package frontController.commands.getRequest;

import frontController.commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Index Page Command
 */
public class IndexPageCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/index.jsp");
    }
}
