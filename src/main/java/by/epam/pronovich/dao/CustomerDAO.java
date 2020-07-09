package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Customer;

public interface CustomerDAO {

    Customer getById(Integer id) throws DAOException;

    void registr(String login, String password) throws DAOException;

    Customer autorize(String login, String password) throws DAOException;

    void update(Customer customer) throws DAOException;

    String getLogin(String login) throws DAOException;
}
