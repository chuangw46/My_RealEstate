package frontController.commands.postRequest;

import frontController.commands.FrontCommand;

import models.User;

import dataSourceLayer.mappers.userMapper.UserMapper;
import service.AppSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Get Sign in Page Command
 */
public class SignInCommand extends FrontCommand {
    private UserMapper userMapper = new UserMapper();
    public void process() throws ServletException, IOException{
        String email = this.request.getParameter("email");
        String password = this.request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            User user = userMapper.getUserByEmail(email);
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
