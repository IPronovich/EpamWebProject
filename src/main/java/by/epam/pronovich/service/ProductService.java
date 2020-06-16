package by.epam.pronovich.service;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(Integer id);

    List<Product> getAll();

    List<Product> getByCategoryId(Integer id);

    Product save(Product product);

    void update(Product product);

    List<Product> sort(List<Product> productList, String order);


}
