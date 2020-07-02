package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = null;
        try {
            brands = DAOProvider.getINSTANCE().getBrandDAO().getAll();
        } catch (DAOException e) {
            logger.warn("Failed get all brands", e);
            throw new ServiceException(e);
        }
        return brands;
    }
}
