package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.BrandDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.util.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAOImpl implements BrandDAO {

    private final Logger logger = LoggerFactory.getLogger(BrandDAOImpl.class);
    private final String getAll = "SELECT id, name from shop.brand";

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAll)) {
            return getBrandList(brands, preparedStatement);
        } catch (SQLException e) {
            logger.warn("Failed get all brands", e);
            throw new DAOException(e);
        }
    }

    private List<Brand> getBrandList(List<Brand> brands, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            brands.add(getBrandFrom(resultSet));
        }
        return brands;
    }

    private Brand getBrandFrom(ResultSet resultSet) throws SQLException {
        return Brand.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }
}
