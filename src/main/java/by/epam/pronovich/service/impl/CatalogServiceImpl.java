package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Catalog> getAll() {
        return DAOProvider.getINSTANCE().getCatalogDAO().getAll();
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
