package by.epam.pronovich.util;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class Validator {

    private final int MIN_PASSWORD_LENGTH = 6;

    public boolean validateRegistration(HttpServletRequest request) {
        return false;
    }

    public boolean validatePassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        boolean correctLength = (password.length() >= MIN_PASSWORD_LENGTH && repeatPassword.length() >= MIN_PASSWORD_LENGTH);
        boolean repetablePassword = (password == repeatPassword);
        return (correctLength && repetablePassword);
    }

}
