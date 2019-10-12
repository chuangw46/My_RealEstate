package frontController;

import frontController.commands.FrontCommand;
import frontController.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * the class represents a servlet which handles GET and POST requests from users
 */

@WebServlet(name = "frontController.FrontServlet", urlPatterns = {"/frontServlet"})
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handle POST request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request, "postRequest.");
        command.init(getServletContext(), request, response);
        command.process();
    }

    /**
     * Handle GET request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request, "getRequest.");
        command.init(getServletContext(), request, response);
        command.process();
    }

    /**
     * Get command class based on the request command parameter
     * @param request
     * @param pkg
     * @return
     */
    private FrontCommand getCommand(HttpServletRequest request, String pkg){
        try{
            return (FrontCommand) getCommandClass(request, pkg).newInstance();
        }
        catch(Exception e){
            System.out.println("Getting Command Class fails.");
            return null;
        }
    }

    /**
     * Helper function for getCommand()
     * @param request
     * @param pkg
     * @return
     */
    private Class getCommandClass(HttpServletRequest request, String pkg){
        Class result;
        final String commandClassName = "frontController.commands." + pkg + (String) request.getParameter("command") + "Command";
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
