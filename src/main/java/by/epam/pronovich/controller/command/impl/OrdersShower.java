package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.BookingStatus;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrdersShower implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        List<Booking> bookingList = ServiceProvider.getINSTANCE().getBookingService().getAll();
        List<ProductBooking> productBookings = ServiceProvider.getINSTANCE().getProductBookingService().getByBookings(bookingList);
        req.setAttribute("productBookings", productBookings);

        BookingStatus[] values = BookingStatus.values();
        req.setAttribute("status", values);

        servletContext.getRequestDispatcher(JspPathUtil.get("orders")).forward(req, resp);
    }
}
