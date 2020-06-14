package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Catalog;

import java.util.List;

public interface CatalogDAO {

    List<Catalog> getAllMainCategory() throws DAOException;

    List<Catalog> getCategorysByParentId(Integer id) throws DAOException;

    List<Catalog> getAll() throws DAOException;
}
