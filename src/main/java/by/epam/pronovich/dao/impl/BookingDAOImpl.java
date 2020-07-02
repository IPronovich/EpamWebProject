package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.BookingDAO;
import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.BookingStatus;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.util.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static by.epam.pronovich.model.BookingStatus.INPROCESSING;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class BookingDAOImpl implements BookingDAO {

    private final Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);

    private final String ADD = "INSERT INTO shop.booking (date, status, customer_id) VALUES (?,?,?)";
    private final String GET_ALL = "SELECT id, date, status, customer_id from shop.booking";
    private final String GET_BY_CUSTOMER = GET_ALL + " where customer_id=?";
    private final String UPDATE_STATUS = "UPDATE shop.booking SET status=? where id=?";


    @Override
    public List<Booking> getAll() {
        List<Booking> bookingList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Booking booking = Booking.builder()
                        .id(resultSet.getInt("id"))
                        .date(resultSet.getDate("date").toLocalDate())
                        .bookingStatus(BookingStatus.valueOf(resultSet.getString("status")))
                        .customer(DAOProvider.getINSTANCE().getCustomerDAO().getById(resultSet.getInt("customer_id")))
                        .build();
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            logger.warn("Failed get all booking", e);
            throw new DAOException(e);
        }
        return bookingList;
    }

    @Override
    public List<Booking> getByCustomer(Customer customer) {
        List<Booking> bookingList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CUSTOMER)) {
            preparedStatement.setInt(1, customer.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Booking booking = Booking.builder()
                        .id(resultSet.getInt("id"))
                        .date(resultSet.getDate("date").toLocalDate())
                        .bookingStatus(BookingStatus.valueOf(resultSet.getString("status")))
                        .customer(customer)
                        .build();
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            logger.warn("Failed get all booking by customer", e);
            throw new DAOException(e);
        }
        return bookingList;
    }

    @Override
    public Booking add(Customer customer) {
        Booking booking = Booking.builder().date(LocalDate.now()).bookingStatus(INPROCESSING).customer(customer).build();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD, RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, Date.valueOf(booking.getDate()));
            preparedStatement.setString(2, booking.getBookingStatus().name());
            preparedStatement.setInt(3, booking.getCustomer().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                booking.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            logger.warn("Failed add booking", e);
            throw new DAOException(e);
        }
        return booking;
    }

    @Override
    public void updateStatus(Booking booking) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS)) {
            preparedStatement.setString(1, booking.getBookingStatus().name());
            preparedStatement.setInt(2, booking.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Failed update booking status", e);
            throw new DAOException(e);
        }
    }
}
