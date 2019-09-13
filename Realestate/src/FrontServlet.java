import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import commands.FrontCommand;
import commands.UnknownCommand;

@WebServlet(name = "FrontServlet", urlPatterns = {"/frontServlet"})
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request){
        try{
            return (FrontCommand) getCommandClass(request).newInstance();
        }
        catch(Exception e){
            System.out.println("Getting Command Class fails.");
            return null;
        }
    }

    private Class getCommandClass(HttpServletRequest request){
        Class result;
        final String commandClassName = "commands." + (String) request.getParameter("command") + "Command";
        System.out.println(commandClassName);
        try{
            result = Class.forName(commandClassName);
            System.out.println(result);
        } catch(ClassNotFoundException e){
            result = UnknownCommand.class;
        }
        System.out.println(result);
        return result;
    }
}
