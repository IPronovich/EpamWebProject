package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogServiceImpl implements CatalogService {

    private final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Override
    public List<Catalog> getAllSubCategory() {
        List<Catalog> catalogList = null;
        try {
            catalogList = DAOProvider.getINSTANCE().getCatalogDAO().getAll().stream()
                    .filter(it -> it.getParentId() != 0)
                    .sorted(Comparator.comparing(Catalog::getDescription))
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            logger.warn("Failed get all sub category", e);
            throw new ServiceException(e);
        }
        return catalogList;
    }

    @Override
    public List<Catalog> getAllMainCategory() {
        List<Catalog> catalogList = null;
        try {
            catalogList = DAOProvider.getINSTANCE().getCatalogDAO().getAllMainCategory();
        } catch (DAOException e) {
            logger.warn("Failed get all main category", e);
            throw new ServiceException(e);
        }
        return catalogList;
    }

    @Override
    public List<Catalog> getCategorysByParentId(Integer id) {
        List<Catalog> catalogList = null;
        try {
            catalogList = DAOProvider.getINSTANCE().getCatalogDAO().getCategorysByParentId(id);
        } catch (DAOException e) {
            logger.warn("Failed get category by parrent id", e);
            throw new ServiceException(e);
        }
        return catalogList;
    }
}
