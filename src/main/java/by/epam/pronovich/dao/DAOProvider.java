package by.epam.pronovich.dao;

import by.epam.pronovich.dao.impl.*;
import by.epam.pronovich.model.Brand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DAOProvider {

    @Getter
    private final static DAOProvider INSTANCE = new DAOProvider();

    private final CatalogDAO catalogDAO = new CatalogDAOImpl();
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final ReviewDAO reviewDAO = new ReviewDAOImpl();
    private final BrandDAO brandDAO = new BrandDAOImpl();

}