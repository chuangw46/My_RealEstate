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

@WebServlet(name = "FrontServlet", urlPatterns = {"/frontServlet"})
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request, "postRequest.");
        command.init(getServletContext(), request, response);
        command.process();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request, "getRequest.");
        command.init(getServletContext(), request, response);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request, String pkg){
        try{
            return (FrontCommand) getCommandClass(request, pkg).newInstance();
        }
        catch(Exception e){
            System.out.println("Getting Command Class fails.");
            return null;
        }
    }

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
