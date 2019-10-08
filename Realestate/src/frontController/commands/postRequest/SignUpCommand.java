package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
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
            UsernamePasswordToken token = new UsernamePasswordToken(email, password);
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();
            try {
                currentUser.login(token);
                AppSession.init(user);
                FlashMessage.createSuccessMessage(request.getSession(), "Hi " + user.getName() + ", " +
                        "Welcome to Realestate website.  Enjoy your journey here :)");
                forward("/index.jsp");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                FlashMessage.createErrorMessage(request.getSession(), "Account is created, please sign in now.");
                forward("/signin.jsp");
            }
        } else {
            FlashMessage.createErrorMessage(request.getSession(), "This email already exists.");
            forward("/signup.jsp");
        }
    }
}
