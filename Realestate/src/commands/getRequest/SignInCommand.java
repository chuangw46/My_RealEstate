package commands.getRequest;

import commands.FrontCommand;
import service.UserManagement;
import model.Agent;
import model.Client;
import model.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Sign in Page Command
 */
public class SignInCommand extends FrontCommand {
    public void process() throws ServletException, IOException{
        String email = this.request.getParameter("email");
        String password = this.request.getParameter("password");
        User user = UserManagement.login(email, password);
        if (user != null) {
//            System.out.println(user.getName());
            request.getSession().setAttribute("currentUser", user);
            if (user instanceof  Agent) {
                request.getSession().setAttribute("userType", "Agent");
            }
            else if (user instanceof Client) {
                request.getSession().setAttribute("userType", "Client");
            }
            FlashMessage.createSuccessMessage(request.getSession(), "Hi " + user.getName() + ", " +
                    "Welcome to Realestate website.  Enjoy your journey here :)");
            forward("/index.jsp");
        }
        else {
            FlashMessage.createErrorMessage(request.getSession(), "We didn't recognise the " +
                    "username or password you entered. Please try again!");
            forward("/signin.jsp");
        }

    }
}
