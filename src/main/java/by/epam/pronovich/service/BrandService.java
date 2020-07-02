package by.epam.pronovich.service;

import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll()throws ServiceException;
}
