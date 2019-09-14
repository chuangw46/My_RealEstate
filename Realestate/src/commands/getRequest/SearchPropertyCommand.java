package commands.getRequest;

import commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Search Property Page Command
 */
public class SearchPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-results.jsp");
    }
}
