package commands.postRequest;

import commands.FrontCommand;
import service.AppSession;
import service.UserManagement;
import models.Agent;
import models.User;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Post: update profile Command
 */
public class UpdateProfileCommand extends FrontCommand {

    public void process() throws ServletException, IOException {
        User user = null;
        if (AppSession.isAuthenticated()) {
            user = AppSession.getUser();
            int id = user.getId();
            String name = request.getParameter("name");
            if (AppSession.hasRole(AppSession.AGENT_ROLE)) {
                String phone = request.getParameter("phone");
                String company_name = request.getParameter("company-name");
                String company_address = request.getParameter("company-address");
                String company_website = request.getParameter("company-website");
                String biography = request.getParameter("biography");
                user = UserManagement.updateAgentProfile(user, name, phone, company_name,
                        company_address, company_website, biography);
            }
            else if (AppSession.hasRole(AppSession.CLIENT_ROLE)){
                user = UserManagement.updateClientProfile(user, name);
            }
        }
        if (user != null) {
            FlashMessage.createSuccessMessage(request.getSession(), "Your profile has been " +
                    "updated!");
            forward("/profile.jsp");
        }
        else {
            FlashMessage.createErrorMessage(request.getSession(), "Fail to update your profile! " +
                    "Try again please.");
            forward("/profile.jsp");
        }

    }
}
