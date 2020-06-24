package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Override
    public Booking add(Customer customer) {
        return DAOProvider.getINSTANCE().getBookingDAO().add(customer);
    }

    @Override
    public List<Booking> getAll() {
        return DAOProvider.getINSTANCE().getBookingDAO().getAll();
    }

    @Override
    public List<Booking> getByCustomer(Customer customer) {
        return DAOProvider.getINSTANCE().getBookingDAO().getByCustomer(customer);
    }

    @Override
    public void update(Booking booking) {
        DAOProvider.getINSTANCE().getBookingDAO().updateStatus(booking);
    }
}
