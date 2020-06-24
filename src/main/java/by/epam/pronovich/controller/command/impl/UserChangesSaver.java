package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserChangesSaver implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        Customer customer = getCustomerFrom(req);
        ServiceProvider.getINSTANCE().getCustomerService().update(customer);
        req.getSession().setAttribute("customer", customer);
        resp.sendRedirect("/profile");
    }

    private Customer getCustomerFrom(HttpServletRequest req) {
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        return Customer.builder()
                .login(customer.getLogin())
                .id(customer.getId())
                .email(req.getParameter("email"))
                .name(req.getParameter("name"))
                .lastName(req.getParameter("lastName")).address(req.getParameter("address"))
                .phoneNumber((Integer.valueOf(req.getParameter("phone")))).build();
    }
}
