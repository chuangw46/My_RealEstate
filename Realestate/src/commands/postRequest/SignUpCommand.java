package commands.postRequest;

import commands.FrontCommand;
import service.UserManagement;
import model.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Post: sign up an account Command
 */
public class SignUpCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("user-type");
        User user = UserManagement.signup(email, password, name, type);
        if (user != null) {
            request.getSession().setAttribute("currentUser", user);
            request.getSession().setAttribute("userType", type);
            forward("/index.jsp");
        } else {
            FlashMessage.createErrorMessage(request.getSession(), "This email already exists.");
            forward("/signup.jsp");
        }
    }
}
