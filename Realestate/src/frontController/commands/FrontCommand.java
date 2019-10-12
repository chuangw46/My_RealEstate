package frontController.commands;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /**
     * pass http and servlet context so that command children class can access
     * @param context
     * @param request
     * @param response
     */
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response){
        this.context = context;
        this.request = request;
        this.response = response;
    }

    /**
     * to be implemented by command children classes
     * @throws ServletException
     * @throws IOException
     */
    abstract public void process() throws ServletException, IOException;

    /**
     * forward to the target jsp
     * @param target
     * @throws ServletException
     * @throws IOException
     */
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}
