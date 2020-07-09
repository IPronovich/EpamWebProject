package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.sorting.SortingName;
import by.epam.pronovich.service.ProductService;
import by.epam.pronovich.service.sorting.Sorting;
import by.epam.pronovich.service.sorting.impl.NameAscSorting;
import by.epam.pronovich.service.sorting.impl.NameDescSorting;
import by.epam.pronovich.service.sorting.impl.PriceAscSorting;
import by.epam.pronovich.service.sorting.impl.PriceDescSorting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.pronovich.service.sorting.SortingName.*;

public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final Map<SortingName, Sorting> sortingBox = new HashMap<>();

    public ProductServiceImpl() {
        sortingBox.put(PRICEASC, new PriceAscSorting());
        sortingBox.put(PRICEDESC, new PriceDescSorting());
        sortingBox.put(NAMEASC, new NameAscSorting());
        sortingBox.put(NAMEDESC, new NameDescSorting());
    }

    @Override
    public List<Product> sort(List<Product> productList, String order) {
        List<Product> products = null;
        try {
            Sorting sorting = sortingBox.get(SortingName.valueOf(order.toUpperCase()));
            products = sorting.sort(productList);
        } catch (Exception e) {
            logger.warn("Failed sorting products", e);
            throw new ServiceException(e);
        }
        return products;
    }

    @Override
    public List<Product> search(String text) throws ServiceException {
        List<Product> products = null;
        try {
            products = DAOProvider.getINSTANCE().getProductDAO().seach(text);
        } catch (DAOException e) {
            logger.warn("Failed product searching", e);
            throw new ServiceException(e);
        }
        return products;
    }


    @Override
    public Product getById(Integer id) {
        Product product;
        try {
            product = DAOProvider.getINSTANCE().getProductDAO().getById(id);
        } catch (DAOException e) {
            logger.warn("Failed get product by id", e);
            throw new ServiceException(e);
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = null;
        try {
            products = DAOProvider.getINSTANCE().getProductDAO().getAll();
        } catch (DAOException e) {
            logger.warn("Failed get all products", e);
            throw new ServiceException(e);
        }
        return products;
    }

    @Override
    public List<Product> getByCategoryId(Integer id) {
        List<Product> products = null;
        try {
            products = DAOProvider.getINSTANCE().getProductDAO().getByCategoryId(id);
        } catch (DAOException e) {
            logger.warn("Failed get all products by category", e);
            throw new ServiceException(e);
        }
        return products;
    }

    @Override
    public Product save(Product product) {
        Product result = null;
        try {
            product = DAOProvider.getINSTANCE().getProductDAO().save(product);
        } catch (DAOException e) {
            logger.warn("Failed saving product", e);
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public void update(Product product) {
        try {
            DAOProvider.getINSTANCE().getProductDAO().update(product);
        } catch (DAOException e) {
            logger.warn("Failed product info updating", e);
            throw new ServiceException(e);
        }
    }
}
