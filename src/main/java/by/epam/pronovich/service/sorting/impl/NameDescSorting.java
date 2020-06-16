package by.epam.pronovich.service.sorting.impl;

import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.sorting.Sorting;

import java.util.List;
import java.util.stream.Collectors;

public class NameDescSorting implements Sorting {

    @Override
    public List<Product> sort(List<Product> productList) {
        return productList.stream()
                .sorted((o1, o2) -> o2.getBrand().getName().compareTo(o1.getBrand().getName()))
                .collect(Collectors.toList());
    }
}
