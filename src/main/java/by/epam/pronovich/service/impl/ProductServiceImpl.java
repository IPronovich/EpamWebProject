package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public Product getById(Integer id) {
        return DAOProvider.getINSTANCE().getProductDAO().getById(id);
    }

    @Override
    public List<Product> getAll() {
        return DAOProvider.getINSTANCE().getProductDAO().getAll();
    }

    @Override
    public List<Product> getByCategoryId(Integer id) {
        return DAOProvider.getINSTANCE().getProductDAO().getByCategoryId(id);
    }

    @Override
    public Product save(Product product) {
        return DAOProvider.getINSTANCE().getProductDAO().save(product);
    }

    @Override
    public void update(Product product) {
        DAOProvider.getINSTANCE().getProductDAO().update(product);
    }
}
