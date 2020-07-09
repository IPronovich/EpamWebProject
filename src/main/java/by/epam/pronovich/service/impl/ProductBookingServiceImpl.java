package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.service.ProductBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductBookingServiceImpl implements ProductBookingService {

    private final Logger logger = LoggerFactory.getLogger(ProductBookingServiceImpl.class);

    @Override
    public void add(Booking booking, List<Product> products) {
        try {
            DAOProvider.getINSTANCE().getProductBookingDAO().add(booking, products);
        } catch (DAOException e) {
            logger.warn("Failed add ProductBooking",e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductBooking> getByBookings(List<Booking> bookings) {
        List<ProductBooking> productBookingList = null;
        try {
            productBookingList = DAOProvider.getINSTANCE().getProductBookingDAO().getByBookings(bookings);
        } catch (DAOException e) {
            logger.warn("Failed get ProductBookings by bookings",e);
            throw new ServiceException(e);
        }
        return productBookingList;
    }
}
