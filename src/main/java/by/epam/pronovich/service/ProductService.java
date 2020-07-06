package by.epam.pronovich.service;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(Integer id) throws ServiceException;

    List<Product> getAll() throws ServiceException;

    List<Product> getByCategoryId(Integer id) throws ServiceException;

    Product save(Product product) throws ServiceException;

    void update(Product product) throws ServiceException;

    List<Product> sort(List<Product> productList, String order) throws ServiceException;

    List<Product> search(String text) throws ServiceException;


}
