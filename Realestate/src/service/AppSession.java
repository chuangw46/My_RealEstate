package service;

import models.Property;
import models.User;
import org.apache.shiro.SecurityUtils;
import service.DTO.AgentDTO;

import java.util.List;

public class AppSession {
    /**
     * Class that manages the what should be stored and modified in the session
     */
    private static final String USER_ATTRIBUTE_NAME = "currentUser";
    private static final String OTHER_USER_ATTRIBUTE_NAME = "otherUser";
    private static final String PROPERTY_ATTRIBUTE_NAME = "currentProperty";
    private static final String PROPERTY_LIST_ATTRIBUTE_NAME = "propertyList";
    private static final String AGENT_LIST_ATTRIBUTE_NAME = "agentList";
    private static final String LIKE_PROPERTY_ATTRIBUTE_NAME = "likeProperty";
    public static final String CLIENT_ROLE = "Client";
    public static final String AGENT_ROLE = "Agent";

    /**
     * check if user has the authorisation
     * @param role
     * @return true or false
     */
    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    /**
     * check if user is logged in
     * @return true or false
     */
    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    /**
     * store user object in session
     * @param user
     */
    public static void init(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    public static String getSessionId() {
        return (String)SecurityUtils.getSubject().getSession().getId();
    }

    public static User getUser() {
        return (User)SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }

    public static AgentDTO getOtherUser() {
        return (AgentDTO) SecurityUtils.getSubject().getSession().getAttribute(OTHER_USER_ATTRIBUTE_NAME);
    }

    public static void setOtherUser(AgentDTO user) {
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

    public static boolean getLikeProperty() {
        return (boolean)SecurityUtils.getSubject().getSession().getAttribute(LIKE_PROPERTY_ATTRIBUTE_NAME);
    }

    public static void setLikeProperty(boolean i) {
        SecurityUtils.getSubject().getSession().setAttribute(LIKE_PROPERTY_ATTRIBUTE_NAME, i);
    }

    public static void removeLikeProperty() {
        SecurityUtils.getSubject().getSession().removeAttribute(LIKE_PROPERTY_ATTRIBUTE_NAME);
    }
}
