package by.epam.pronovich.dao;

import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;

import java.util.List;

public interface BookingDAO {

    List<Booking> getAll();

    Booking add(Customer customer);

    List<Booking> getByCustomer(Customer customer);

    void updateStatus(Booking booking);

}
