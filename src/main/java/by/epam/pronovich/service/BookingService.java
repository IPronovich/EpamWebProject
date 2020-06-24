package by.epam.pronovich.service;

import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;

import java.util.List;

public interface BookingService {

    Booking add(Customer customer);

    List<Booking> getAll();

    List<Booking> getByCustomer(Customer customer);

    void update(Booking booking);
}
