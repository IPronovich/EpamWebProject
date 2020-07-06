package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.CatalogService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Catalog> getAllSubCategory() {
        return DAOProvider.getINSTANCE().getCatalogDAO().getAll().stream()
                .filter(it -> it.getParentId() != 0)
                .sorted(Comparator.comparing(Catalog::getDescription))
                .collect(Collectors.toList());
    }

    @Override
    public List<Catalog> getAllMainCategory() {
        return DAOProvider.getINSTANCE().getCatalogDAO().getAllMainCategory();
    }

    @Override
    public List<Catalog> getCategorysByParentId(Integer id) {
        return DAOProvider.getINSTANCE().getCatalogDAO().getCategorysByParentId(id);
    }
}
