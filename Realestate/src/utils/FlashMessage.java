package utils;

import javax.servlet.http.HttpSession;

public final class FlashMessage {
    public static void createAlertMessage(HttpSession session, String messageKey) {
        session.setAttribute("alertMessage", messageKey);
    }

    public static void createInfoMessage(HttpSession session, String messageKey) {
        session.setAttribute("infoMessage", messageKey);
    }

    public static void createErrorMessage(HttpSession session, String messageKey) {
        session.setAttribute("errorMessage", messageKey);
    }

    public static void createSuccessMessage(HttpSession session, String messageKey) {
        session.setAttribute("successMessage", messageKey);
    }
}
