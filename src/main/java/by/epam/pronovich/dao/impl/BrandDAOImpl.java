package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.BrandDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAOImpl implements BrandDAO {

    private final String getAll = "SELECT id, name from shop.brand";

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAll)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                brands.add(getBrandFrom(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
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
