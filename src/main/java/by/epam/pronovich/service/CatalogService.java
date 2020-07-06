package by.epam.pronovich.service;

import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Catalog;

import java.util.List;

public interface CatalogService {

    List<Catalog> getAllSubCategory() throws ServiceException;

    List<Catalog> getAllMainCategory() throws ServiceException;

    List<Catalog> getCategorysByParentId(Integer id) throws ServiceException;
}
