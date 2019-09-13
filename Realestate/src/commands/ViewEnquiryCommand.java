package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class ViewEnquiryCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/enquiry-list.jsp");
    }
}
