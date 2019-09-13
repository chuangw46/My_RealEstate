package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class PublishPropertyCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        String action = this.request.getParameter("action");
        if (action.equals("redirect")) {
            forward("/property-publish.jsp");
        }
        else if (action.equals("publish")){
            forward("/index.jsp");
        }
        else if (action.equals("edit")){
            forward("/property-publish.jsp");
        }
    }
}
