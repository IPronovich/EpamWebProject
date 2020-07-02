package by.epam.pronovich.dao.impl;


import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.dao.ProductBookingDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.util.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBookingDAOImpl implements ProductBookingDAO {

    private final Logger logger = LoggerFactory.getLogger(ProductBookingDAOImpl.class);

    private final String ADD = "INSERT INTO shop.product_booking (booking_id, product_id) values (?, ?)";
    private final String GET_PRODUCTLIST_IN_BOOKING = "SELECT product_id " +
            "FROM shop.product_booking " +
            "where booking_id =?";

    @Override
    public List<ProductBooking> getByBookings(List<Booking> bookings) {
        ArrayList<ProductBooking> productBookings = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTLIST_IN_BOOKING)) {
            for (Booking booking : bookings) {
                List<Product> productList = new ArrayList<>();
                preparedStatement.setInt(1, booking.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Product product = DAOProvider.getINSTANCE().getProductDAO().getById(resultSet.getInt("product_id"));
                    productList.add(product);
                }
                ProductBooking productBooking = ProductBooking.builder()
                        .booking(booking)
                        .products(productList)
                        .build();
                productBookings.add(productBooking);
            }
        } catch (SQLException e) {
            logger.warn("Failed get all ProductBooking", e);
            throw new DAOException(e);
        }
        return productBookings;
    }

    @Override
    public void add(Booking booking, List<Product> products) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            for (Product product : products) {
                preparedStatement.setInt(1, booking.getId());
                preparedStatement.setInt(2, product.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.warn("Failed add ProductBooking", e);
            throw new DAOException(e);
        }
    }
}
