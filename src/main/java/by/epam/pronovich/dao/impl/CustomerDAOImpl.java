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

    private String GET_ALL = "select id, login, email, name, last_name, role, phone_number, address from shop.customer";

    private final String LOGINATION = GET_ALL + " WHERE login=? AND password=?";

    private String REGISTR = "INSERT into shop.customer (login,password,role) values (?,?,?)";

    private String GET_BY_ID = GET_ALL + " where id=?";

    private String UPDATE = "UPDATE shop.customer SET email=?, name=?, last_name=?, phone_number=?, address=? where id=?";

    @Override
    public Customer getById(Integer id) {
        Customer customer = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = createCustomer(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return customer;
    }

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
                .id(resultSet.getInt("id"))
                .login(resultSet.getString("login"))
                .email(resultSet.getString("email"))
                .name(resultSet.getString("name"))
                .lastName(resultSet.getString("last_name"))
                .role(Role.valueOf(resultSet.getString("role")))
                .phoneNumber(resultSet.getInt("phone_number"))
                .address(resultSet.getString("address"))
                .build();
    }
}
