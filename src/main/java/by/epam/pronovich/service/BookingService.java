package by.epam.pronovich.service;

import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;

import java.util.List;

public interface BookingService {

    Booking add(Customer customer) throws ServiceException;

    List<Booking> getAll() throws ServiceException;

    List<Booking> getByCustomer(Customer customer) throws ServiceException;

    void update(Booking booking) throws ServiceException;
}
