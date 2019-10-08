package frontController.commands.getRequest;

import frontController.commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Search Agents Page Command
 */
public class SearchAgentCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-results.jsp");
    }
}