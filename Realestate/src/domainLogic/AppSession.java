package domainLogic;

import models.User;
import org.apache.shiro.SecurityUtils;

public class AppSession {
    public static final String USER_ATTRIBUTE_NAME = "currentUser";
    public static final String CLIENT_ROLE = "Client";
    public static final String AGENT_ROLE = "Agent";

    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static void init(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    public static User getUser() {
        return (User)SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }
}
