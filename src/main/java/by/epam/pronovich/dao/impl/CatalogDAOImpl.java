package by.epam.pronovich.dao.impl;

import by.epam.pronovich.dao.CatalogDAO;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAOImpl implements CatalogDAO {

    private final String GET_ALL_CATEGORY = " SELECT id, parent_id, description from shop.catalog";

    private final String ALL_MAIN_CATEGORY = GET_ALL_CATEGORY + " where parent_id is null";

    private final String GET_CATEGORY_BY_PARENT_ID = GET_ALL_CATEGORY + " where parent_id=(?)";

    @Override
    public List<Catalog> getAll() throws DAOException {
        ArrayList<Catalog> categorys = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categorys.add(getCatalogFrom(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return categorys;
    }

    @Override
    public List<Catalog> getAllMainCategory() throws DAOException {
        ArrayList<Catalog> categorys = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_MAIN_CATEGORY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categorys.add(getCatalogFrom(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return categorys;
    }

    @Override
    public List<Catalog> getCategorysByParentId(Integer id) throws DAOException {
        ArrayList<Catalog> categorys = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_PARENT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categorys.add(getCatalogFrom(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return categorys;
    }

    private Catalog getCatalogFrom(ResultSet resultSet) throws SQLException {
        return Catalog.builder()
                .id(resultSet.getInt("id"))
                .parentId(resultSet.getInt("parent_id"))
                .description(resultSet.getString("description")).build();
    }
}
