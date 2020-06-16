package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.sorting.SortingName;
import by.epam.pronovich.service.ProductService;
import by.epam.pronovich.service.sorting.Sorting;
import by.epam.pronovich.service.sorting.impl.NameAscSorting;
import by.epam.pronovich.service.sorting.impl.NameDescSorting;
import by.epam.pronovich.service.sorting.impl.PriceAscSorting;
import by.epam.pronovich.service.sorting.impl.PriceDescSorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.pronovich.service.sorting.SortingName.*;

public class ProductServiceImpl implements ProductService {

    private final Map<SortingName, Sorting> sortingBox = new HashMap<>();

    public ProductServiceImpl() {
        sortingBox.put(PRICEASC, new PriceAscSorting());
        sortingBox.put(PRICEDESC, new PriceDescSorting());
        sortingBox.put(NAMEASC, new NameAscSorting());
        sortingBox.put(NAMEDESC, new NameDescSorting());
    }

    @Override
    public List<Product> sort(List<Product> productList, String order) {
        Sorting sorting = sortingBox.get(SortingName.valueOf(order.toUpperCase()));
        return sorting.sort(productList);
    }


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
