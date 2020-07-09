package by.epam.pronovich.util;

import by.epam.pronovich.service.ServiceProvider;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@UtilityClass
public class Validator {

    private final int MIN_PASSWORD_LENGTH = 6;

    public boolean validateRegistration(HttpServletRequest request) {
        return (validateLogin(request) & validatePassword(request));
    }

    public boolean validateLogin(HttpServletRequest request) {
        boolean result = true;
        String login = request.getParameter("login");
        String value = ServiceProvider.getINSTANCE().getCustomerService().getLogin(login);
        if (Objects.nonNull(value)) {
            result = false;
            request.setAttribute("checkLogin", "login.wrong");
        }
        return result;
    }

    public boolean validatePassword(HttpServletRequest request) {
        boolean result = true;
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        boolean correctLength = (password.length() >= MIN_PASSWORD_LENGTH && repeatPassword.length() >= MIN_PASSWORD_LENGTH);
        boolean repetablePassword = (password.equals(repeatPassword));
        if (!correctLength || !repetablePassword) {
            result = false;
            request.setAttribute("checkPassword", "password.wrong");
        }
        return result;
    }
}
