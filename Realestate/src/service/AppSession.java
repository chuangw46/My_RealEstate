package service;

import models.Property;
import models.User;
import org.apache.shiro.SecurityUtils;

import java.util.List;

public class AppSession {
    private static final String USER_ATTRIBUTE_NAME = "currentUser";
    private static final String OTHER_USER_ATTRIBUTE_NAME = "otherUser";
    private static final String PROPERTY_ATTRIBUTE_NAME = "currentProperty";
    private static final String PROPERTY_LIST_ATTRIBUTE_NAME = "propertyList";
    private static final String AGENT_LIST_ATTRIBUTE_NAME = "agentList";
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

    public static String getSessionId() {
        return (String)SecurityUtils.getSubject().getSession().getId();
    }

    public static User getUser() {
        return (User)SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }

    public static User getOtherUser() {
        return (User)SecurityUtils.getSubject().getSession().getAttribute(OTHER_USER_ATTRIBUTE_NAME);
    }

    public static void setOtherUser(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(OTHER_USER_ATTRIBUTE_NAME, user);
    }

    public static void removeOtherUser() {
        SecurityUtils.getSubject().getSession().removeAttribute(OTHER_USER_ATTRIBUTE_NAME);
    }


    public static Property getProperty() {
        return (Property)SecurityUtils.getSubject().getSession().getAttribute(PROPERTY_ATTRIBUTE_NAME);
    }

    public static void setProperty(Property p) {
        SecurityUtils.getSubject().getSession().setAttribute(PROPERTY_ATTRIBUTE_NAME, p);
    }

    public static void removeProperty() {
        SecurityUtils.getSubject().getSession().removeAttribute(PROPERTY_ATTRIBUTE_NAME);
    }

    public static List<Property> getPropertyList() {
        return (List<Property>) SecurityUtils.getSubject().getSession().getAttribute(PROPERTY_LIST_ATTRIBUTE_NAME);
    }

    public static void setPropertyList(List<Property> ps) {
        SecurityUtils.getSubject().getSession().setAttribute(PROPERTY_LIST_ATTRIBUTE_NAME, ps);
    }

    public static void removePropertyList() {
        SecurityUtils.getSubject().getSession().removeAttribute(PROPERTY_LIST_ATTRIBUTE_NAME);
    }

    public static List<User> getAgentList() {
        return (List<User>) SecurityUtils.getSubject().getSession().getAttribute(AGENT_LIST_ATTRIBUTE_NAME);
    }

    public static void setAgentList(List<User> ul) {
        SecurityUtils.getSubject().getSession().setAttribute(AGENT_LIST_ATTRIBUTE_NAME, ul);
    }

    public static void removeAgentList() {
        SecurityUtils.getSubject().getSession().removeAttribute(AGENT_LIST_ATTRIBUTE_NAME);
    }
}
