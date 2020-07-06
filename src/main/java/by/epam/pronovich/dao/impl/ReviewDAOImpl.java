package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.ReviewDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.util.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    private final Logger logger = LoggerFactory.getLogger(ReviewDAOImpl.class);

    private final String GET_ALL = "SELECT r.id as r_id, text,title, customer_id, product_id, login " +
            "from shop.review as r inner join shop.customer c on r.customer_id = c.id";

    private final String GET_BY_PRODUCT_ID = GET_ALL + " where product_id=?";

    private final String ADD = "INSERT into shop.review (title, text, customer_id, product_id) VALUES (?,?,?,?)";

    @Override
    public void add(Review review) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setString(1, review.getTitle());
            preparedStatement.setString(2, review.getText());
            preparedStatement.setInt(3, review.getCustomer().getId());
            preparedStatement.setInt(4, review.getProduct().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Failed add review", e);
            throw new DAOException(e);
        }
    }


    @Override
    public List<Review> getByProductId(Integer id) {
        ArrayList<Review> reviews = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_PRODUCT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reviews.add(getReviewFrom(resultSet));
            }
        } catch (SQLException e) {
            logger.warn("Failed get all review by product id", e);
            throw new DAOException(e);
        }
        return reviews;
    }


    private Review getReviewFrom(ResultSet resultSet) throws SQLException {
        return Review.builder()
                .id(resultSet.getInt("r_id"))
                .title(resultSet.getString("title"))
                .text(resultSet.getString("text"))
                .customer(Customer.builder()
                        .id(resultSet.getInt("customer_id"))
                        .login(resultSet.getString("login")).build())
                .product(Product.builder()
                        .id(resultSet.getInt("product_id")).build())
                .build();
    }
}