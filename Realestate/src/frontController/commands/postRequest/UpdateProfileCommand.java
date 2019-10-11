package frontController.commands.postRequest;

import frontController.commands.FrontCommand;
import models.Agent;
import models.Client;
import service.AppSession;
import service.UserManagement;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Post: update profile Command
 */
public class UpdateProfileCommand extends FrontCommand {

    public void process() throws ServletException, IOException {
        User user = null;
        if (AppSession.isAuthenticated()) {
            user = AppSession.getUser();
//            int id = user.getId();
            String name = request.getParameter("name");
            try {
                if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                    String phone = request.getParameter("phone");
                    String company_name = request.getParameter("company-name");
                    String company_address = request.getParameter("company-address");
                    String company_website = request.getParameter("company-website");
                    String biography = request.getParameter("biography");
                    Agent agent = (Agent) user;
                    agent.setName(name);
                    agent.setPhone(phone);
                    agent.getCompany().setName(company_name);
                    agent.getCompany().setAddress(company_address);
                    agent.getCompany().setWebsite(company_website);
                    agent.setBio(biography);
                    UserManagement.updateProfile(agent);
                } else if (AppSession.hasRole(AppSession.CLIENT_ROLE)) {
                    Client client = (Client) user;
                    client.setName(name);
                    UserManagement.updateProfile(client);
                }
                FlashMessage.createSuccessMessage("Your profile has been updated!");
                forward("/profile.jsp");
            } catch (SQLException e) {
                FlashMessage.createErrorMessage("Fail to update your profile! Try again please.");
                forward("/profile.jsp");
            }
        }
    }
}
