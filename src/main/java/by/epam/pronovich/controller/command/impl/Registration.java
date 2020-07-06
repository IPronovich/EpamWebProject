package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.Validator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (Validator.validatePassword(req)){
            ServiceProvider.getINSTANCE().getCustomerService().registr(login, password);
            resp.sendRedirect("/olener");
        }
        else {
            req.setAttribute("wronPas", "wronPas");
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}
