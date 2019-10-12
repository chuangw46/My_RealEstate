package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
import models.Agent;
import models.Client;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import service.AppSession;
import service.UserManagement;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Post: sign up an account Command
 */
public class SignUpCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        // retrieve parameters
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("user-type");
        User user;
        // create user object based on user type
        if (type.equals("Client")) {
            user = new Client(email, password, name);
        } else {
            user = new Agent(email, password, name);
        }
        try {
            // sign up this new user through the service layer
            UserManagement.signup(user);
        } catch (SQLException e) {
            FlashMessage.createErrorMessage("This email already exists.");
            forward("/signup.jsp");
        }

        // create token based on input email and password
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();

        try {
            // attempt to login for the subject
            currentUser.login(token);
            // login successfully, add user to session and show success message to user
            AppSession.init(user);
            FlashMessage.createSuccessMessage("Hi " + user.getName() + ", " +
                    "Welcome to Realestate website.  Enjoy your journey here :)");
            forward("/index.jsp");
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            // fail to login, show failure message to user
            FlashMessage.createErrorMessage("Account is created, please sign in now.");
            forward("/signin.jsp");
        }
    }
}
