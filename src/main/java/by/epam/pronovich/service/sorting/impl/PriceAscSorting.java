package by.epam.pronovich.service.sorting.impl;

import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.sorting.Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriceAscSorting implements Sorting {

    @Override
    public List<Product> sort(List<Product> productList) {
        return productList.stream().filter(it -> it.getQuantity() > 0).sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }
}
