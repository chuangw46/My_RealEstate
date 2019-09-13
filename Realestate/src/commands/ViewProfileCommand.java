package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class ViewProfileCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/profile.jsp");
    }
}
