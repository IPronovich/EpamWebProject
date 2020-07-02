package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getByCategoryId(Integer id) throws DAOException;

    Product getById(Integer id) throws DAOException;

    List<Product> getAll() throws DAOException;

    Product save(Product product) throws DAOException;

    void update(Product product) throws DAOException;


}
