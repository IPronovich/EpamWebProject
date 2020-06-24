package by.epam.pronovich.dao;

import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.ProductBooking;

import java.util.List;

public interface ProductBookingDAO {

    void add(Booking booking, List<Product> products);

    List<ProductBooking> getByBookings(List<Booking> bookings);
}
