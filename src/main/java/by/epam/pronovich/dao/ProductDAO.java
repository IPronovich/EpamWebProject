package by.epam.pronovich.dao;

import by.epam.pronovich.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getByCategoryId(Integer id);

    Product getById(Integer id);

    List<Product> getAll();

    Product save(Product product);

    void update(Product product);


}
