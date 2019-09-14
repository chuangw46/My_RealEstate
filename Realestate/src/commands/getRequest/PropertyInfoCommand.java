package commands.getRequest;

import commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class PropertyInfoCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/property-info.jsp");
    }
}
