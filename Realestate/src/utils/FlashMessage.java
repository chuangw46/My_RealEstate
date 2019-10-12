package utils;

import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpSession;

/**
 * create various flash messages in a session
 */

public final class FlashMessage {
    public static void createAlertMessage(String messageKey) {
        SecurityUtils.getSubject().getSession().setAttribute("alertMessage", messageKey);
    }

    public static void createInfoMessage(String messageKey) {
        SecurityUtils.getSubject().getSession().setAttribute("infoMessage", messageKey);
    }

    public static void createErrorMessage(String messageKey) {
        SecurityUtils.getSubject().getSession().setAttribute("errorMessage", messageKey);
    }

    public static void createSuccessMessage(String messageKey) {
        SecurityUtils.getSubject().getSession().setAttribute("successMessage", messageKey);
    }
}
