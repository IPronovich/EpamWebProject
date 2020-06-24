package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Checkout implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Product> basket = (ArrayList<Product>) session.getAttribute("basket");
        Booking booking = DAOProvider.getINSTANCE().getBookingDAO().add(customer);
        DAOProvider.getINSTANCE().getProductBookingDAO().add(booking, basket);
        session.removeAttribute("basket");
        resp.sendRedirect("/olener");
    }
}
