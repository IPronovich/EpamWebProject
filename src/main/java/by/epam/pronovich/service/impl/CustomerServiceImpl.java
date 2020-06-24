package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void registr(String login, Integer password) {
        DAOProvider.getINSTANCE().getCustomerDAO().registr(login, password);

    }

    @Override
    public Customer autorize(String login, String password) {
        return DAOProvider.getINSTANCE().getCustomerDAO().autorize(login, password);
    }

    @Override
    public Customer getById(Integer id) {
        return DAOProvider.getINSTANCE().getCustomerDAO().getById(id);
    }


    @Override
    public void update(Customer customer) {
        DAOProvider.getINSTANCE().getCustomerDAO().update(customer);
    }
}
