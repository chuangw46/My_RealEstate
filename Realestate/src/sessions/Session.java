//package sessions;
//
//import models.Property;
//import models.User;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//public class Session {
//    private static  final  String PROPERTY_ATTRIBUTE_NAME = "currentProperty";
//    private static final String PROPERTY_LIST_ATTRIBUTE_NAME = "propertyList";
//
//    private HttpSession httpSession;
//
//    private Session(HttpSession httpSession) {
//        this.httpSession = httpSession;
//    }
//
//    public static Session refreshSession(HttpSession httpSession) {
//        if(httpSession)
//    }
//
//    public User getUser() {
//        return (User)httpSession.
//    }
//
//    public Property getProperty() {
//        return (Property) httpSession.getAttribute(PROPERTY_ATTRIBUTE_NAME);
//    }
//
//    public void setProperty(Property p) {
//        httpSession.setAttribute(PROPERTY_ATTRIBUTE_NAME, p);
//    }
//
//    public Property getPropertyList() {
//        return (Property) httpSession.getAttribute(PROPERTY_LIST_ATTRIBUTE_NAME);
//    }
//
//    public void setPropertyList(List<Property> ps) {
//        httpSession.setAttribute(PROPERTY_ATTRIBUTE_NAME, ps);
//    }
//}
