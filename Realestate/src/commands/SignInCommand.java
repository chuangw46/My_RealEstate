package commands;

import java.io.IOException;
import javax.servlet.ServletException;

public class SignInCommand extends FrontCommand {
    public void process() throws ServletException, IOException{
        String email = this.request.getParameter("email");
        String password = this.request.getParameter("password");
        forward("/index.jsp");
    }
}
