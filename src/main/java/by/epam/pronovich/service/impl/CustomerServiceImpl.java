package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerServiceImpl implements CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public void registr(String login, String password) {
        try {
            DAOProvider.getINSTANCE().getCustomerDAO().registr(login, password);
        } catch (DAOException e) {
            logger.warn("Failed registration", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer autorize(String login, String password) {
        Customer customer = null;
        try {
            customer = DAOProvider.getINSTANCE().getCustomerDAO().autorize(login, password);
        } catch (DAOException e) {
            logger.warn("Failed autorization", e);
            throw new ServiceException(e);
        }
        return customer;
    }

    @Override
    public Customer getById(Integer id) {
        Customer customer = null;
        try {
            customer = DAOProvider.getINSTANCE().getCustomerDAO().getById(id);
        } catch (DAOException e) {
            logger.warn("Failed get customer by id", e);
            throw new ServiceException(e);
        }
        return customer;
    }


    @Override
    public void update(Customer customer) {
        try {
            DAOProvider.getINSTANCE().getCustomerDAO().update(customer);
        } catch (DAOException e) {
            logger.warn("Failed update customer info", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public String getLogin(String login) throws ServiceException {
        String result = null;
        try {
            result = DAOProvider.getINSTANCE().getCustomerDAO().getLogin(login);
        } catch (DAOException e) {
            logger.warn("Failed get login by login", e);
            throw new ServiceException(e);
        }
        return result;
    }
}
