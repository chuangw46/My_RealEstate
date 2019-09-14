package commands.postRequest;

import commands.FrontCommand;
import domainLogic.UserManagement;
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

        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            int id = user.getId();
            String name = request.getParameter("name");
            if (user instanceof Agent) {
                String phone = request.getParameter("phone");
                String company_name = request.getParameter("company-name");
                String company_address = request.getParameter("company-address");
                String company_website = request.getParameter("company-website");
                String biography = request.getParameter("biography");
                user = UserManagement.updateAgentProfile(user, name, phone, company_name,
                        company_address, company_website, biography);
            }
            else {
                user = UserManagement.updateClientProfile(user, name);
            }
        }
        if (user != null) {
            request.getSession().setAttribute("currentUser", user);
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
