package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    @Override
    public List<Brand> getAll() {
        return DAOProvider.getINSTANCE().getBrandDAO().getAll();
    }
}
