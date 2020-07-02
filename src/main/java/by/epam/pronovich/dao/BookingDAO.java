package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;

import java.util.List;

public interface BookingDAO {

    List<Booking> getAll() throws DAOException;

    Booking add(Customer customer) throws DAOException;

    List<Booking> getByCustomer(Customer customer) throws DAOException;

    void updateStatus(Booking booking) throws DAOException;

}
