package by.epam.pronovich.service;

import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Customer;

public interface CustomerService {

    void registr(String login, String password) throws ServiceException;

    Customer autorize(String login, String password) throws ServiceException;

    Customer getById(Integer id) throws ServiceException;

    void update(Customer customer) throws ServiceException;

    String getLogin(String login) throws ServiceException;
}
