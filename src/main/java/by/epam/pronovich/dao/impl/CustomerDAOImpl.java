package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.CustomerDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Role;
import by.epam.pronovich.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    private final String LOGINATION = "SELECT ID as c_id, LOGIN as c_login, EMAIL as c_email, NAME as c_name," +
            " LAST_NAME as c_latName, ROLE as c_role, PHONE_NUMBER as c_phone, ADDRESS as c_address" +
            " FROM shop.customer WHERE login=? AND password=?";

    private String REGISTR = "INSERT into shop.customer (login,password,role) values (?,?,?)";

    private String SAVE = "INSERT into shop.customer (login, email, name, last_name, phone_number, address) " +
            "values (?,?,?,?,?,?)";

    private String UPDATE = "UPDATE shop.customer SET email=?, name=?, last_name=?, phone_number=?, address=? where id=?";

    @Override
    public void update(Customer customer) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, customer.getEmail());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setInt(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void registr(String login, Integer password) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REGISTR)
        ) {
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, password);
            preparedStatement.setString(3, Role.USER.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Customer autorize(String login, String password) {
        Customer customer = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGINATION)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = createCustomer(resultSet);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return customer;
    }


    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        return Customer.builder()
                .id(resultSet.getInt("c_id"))
                .login(resultSet.getString("c_login"))
                .email(resultSet.getString("c_email"))
                .name(resultSet.getString("c_name"))
                .lastName(resultSet.getString("c_latName"))
                .role(Role.valueOf(resultSet.getString("c_role")))
                .phoneNumber(resultSet.getInt("c_phone"))
                .address(resultSet.getString("c_address"))
                .build();
    }
}
