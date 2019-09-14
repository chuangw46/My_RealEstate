package commands.postRequest;

import commands.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class SignUpCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        String email = this.request.getParameter("email");
        String username = this.request.getParameter("username");
        String password = this.request.getParameter("password");
        forward("/index.jsp");
    }
}
