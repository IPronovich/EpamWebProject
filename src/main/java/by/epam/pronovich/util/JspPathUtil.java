package by.epam.pronovich.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspPathUtil {

    private final String FORMAT = "/WEB-INF/jsp/%s.jsp";

    public String get(String jspPageName) {
        return String.format(FORMAT, jspPageName);
    }
}
