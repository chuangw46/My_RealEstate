package commands;

import domainLogic.Authentication;

import javax.servlet.ServletException;
import java.io.IOException;

public class SignInCommand extends FrontCommand {
    public void process() throws ServletException, IOException{
        String email = this.request.getParameter("email");
        String password = this.request.getParameter("password");
        if (Authentication.login(email, password)) {
            forward("/index.jsp");
        }
        else {
            forward("/signin.jsp");
        }
        // test

    }
}
