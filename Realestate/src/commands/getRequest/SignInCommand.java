package commands.getRequest;

import commands.FrontCommand;
import models.Agent;
import models.Client;
import models.User;
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
//        if (Authentication.login(email, password)) {
        User user = new Agent(1, "aaa@com", "123", "Junhan Yang", "0450001111",
                "XXX", "Tencent", "333 Swanston St.", "www.tencent.com");
//        User user = new Client(1, "aaa.com", "123", "Junhan Yang");
            request.getSession().setAttribute("currentUser", user);
            if (user instanceof  Agent) {
                request.getSession().setAttribute("userType", "Agent");
            }
            else if (user instanceof Client) {
                request.getSession().setAttribute("userType", "Client");
            }
//        }
            FlashMessage.createSuccessMessage(request.getSession(), "Welcome home, you are logged in.");
            forward("/index.jsp");
//        }
//        else {
//            forward("/signin.jsp");
//        }

    }
}
