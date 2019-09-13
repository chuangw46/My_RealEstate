package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class IndexPageCommand extends FrontCommand {
    public void process() throws ServletException, IOException {
        forward("/index.jsp");
    }
}
