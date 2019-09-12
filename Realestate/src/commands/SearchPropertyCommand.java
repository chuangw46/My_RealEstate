package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class SearchPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-results.jsp");
    }
}
