package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class SearchAgentCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-results.jsp");
    }
}