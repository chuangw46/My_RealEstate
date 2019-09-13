package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class ListPropertiesCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-list.jsp");
    }
}
