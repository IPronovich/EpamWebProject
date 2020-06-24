package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.BookingStatus;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusUpdating implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        Booking booking = Booking.builder()
                .bookingStatus(BookingStatus.valueOf(req.getParameter("status")))
                .id(Integer.valueOf(req.getParameter("bookingId")))
                .build();
        ServiceProvider.getINSTANCE().getBookingService().update(booking);
        resp.sendRedirect(req.getHeader("Referer"));

    }
}
