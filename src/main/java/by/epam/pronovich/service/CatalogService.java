package by.epam.pronovich.service;

import by.epam.pronovich.model.Catalog;

import java.util.List;

public interface CatalogService {

    List<Catalog> getAll();

    List<Catalog> getAllMainCategory();

    List<Catalog> getCategorysByParentId(Integer id);
}
