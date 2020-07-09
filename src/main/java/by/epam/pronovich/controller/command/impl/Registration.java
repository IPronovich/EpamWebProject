package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;
import by.epam.pronovich.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {

    private final Logger logger = LoggerFactory.getLogger(Registration.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (Validator.validateRegistration(req)) {
            ServiceProvider.getINSTANCE().getCustomerService().registr(login, password);
            logger.info("User " + login + " registrate in system");
            resp.sendRedirect("/olener");
        } else {
            req.getRequestDispatcher(JspPathUtil.get("registration")).forward(req, resp);
        }
    }
}
