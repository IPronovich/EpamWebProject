package by.epam.pronovich.dao;

import by.epam.pronovich.model.Customer;

public interface CustomerDAO {

    Customer getById(Integer id);

    void registr(String login, Integer password);

    Customer autorize(String login, String password);

    void update(Customer customer);
}
