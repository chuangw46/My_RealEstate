package commands.postRequest;

import commands.FrontCommand;
import utils.FlashMessage;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Post: update profile Command
 */
public class UpdateProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        FlashMessage.createSuccessMessage(request.getSession(), "Your profile has been updated.");
        forward("/profile.jsp");
    }
}
