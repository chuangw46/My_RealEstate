package frontController.commands.postRequest;

import frontController.commands.FrontCommand;

import models.User;

import service.AppSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import service.UserManagement;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Sign in Page Command
 */
public class SignInCommand extends FrontCommand {
    public void process() throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // do the login authentication
            currentUser.login(token);
            // get current user by using getCurrentUser method in the service layer
            User user = UserManagement.getUserBasedOnEmail(email);
            AppSession.init(user);
            FlashMessage.createSuccessMessage(request.getSession(), "Hi " + user.getName() + ", " +
                    "Welcome to Realestate website.  Enjoy your journey here :)");
            forward("/index.jsp");
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            FlashMessage.createErrorMessage(request.getSession(), "We didn't recognise the " +
                    "username or password you entered. Please try again!");
            forward("/signin.jsp");
        }
    }
}
