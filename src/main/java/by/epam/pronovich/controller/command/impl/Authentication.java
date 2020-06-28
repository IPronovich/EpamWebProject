package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authentication implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Customer customer = ServiceProvider.getINSTANCE().getCustomerService().autorize(login, password);
        if (customer == null) {
            resp.sendRedirect("/authentication");
        } else {
            req.getSession().setAttribute("customer", customer);
            resp.sendRedirect("/olener");
        }
    }
}
