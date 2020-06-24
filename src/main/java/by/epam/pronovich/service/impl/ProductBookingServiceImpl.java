package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.service.ProductBookingService;

import java.util.List;

public class ProductBookingServiceImpl implements ProductBookingService {


    @Override
    public void add(Booking booking, List<Product> products) {
        DAOProvider.getINSTANCE().getProductBookingDAO().add(booking, products);

    }

    @Override
    public List<ProductBooking> getByBookings(List<Booking> bookings) {
        return DAOProvider.getINSTANCE().getProductBookingDAO().getByBookings(bookings);
    }
}
