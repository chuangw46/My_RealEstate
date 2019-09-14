package commands.getRequest;

import commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Index Page Command after signing out
 */
public class SignOutCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        if (request.getSession().getAttribute("currentUser") != null) {
            request.getSession().removeAttribute("currentUser");
        }
        forward("/index.jsp");
    }
}
