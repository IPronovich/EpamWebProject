package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Override
    public Booking add(Customer customer) {
        Booking booking = null;
        try {
            booking = DAOProvider.getINSTANCE().getBookingDAO().add(customer);
        } catch (DAOException e) {
            logger.warn("Failed add booking", e);
            throw new ServiceException(e);
        }
        return booking;
    }

    @Override
    public List<Booking> getAll() {
        List<Booking> bookingList = null;
        try {
            bookingList = DAOProvider.getINSTANCE().getBookingDAO().getAll();
        } catch (DAOException e) {
            logger.warn("Failed get all bookings", e);
            throw new ServiceException(e);
        }
        return bookingList;
    }

    @Override
    public List<Booking> getByCustomer(Customer customer) {
        List<Booking> bookingList = null;
        try {
            bookingList = DAOProvider.getINSTANCE().getBookingDAO().getByCustomer(customer);
        } catch (DAOException e) {
            logger.warn("Failed get bookings by customer", e);
            throw new ServiceException(e);
        }
        return bookingList;
    }

    @Override
    public void update(Booking booking) {
        try {
            DAOProvider.getINSTANCE().getBookingDAO().updateStatus(booking);
        } catch (DAOException e) {
            logger.warn("Failed update booking status", e);
            throw new ServiceException(e);
        }
    }
}
