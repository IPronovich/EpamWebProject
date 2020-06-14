package by.epam.pronovich.service;

import by.epam.pronovich.service.impl.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ServiceProvider {

    @Getter
    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private final CustomerService customerService = new CustomerServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final ReviewService reviewService = new ReviewServiceImpl();
    private final CatalogService catalogService = new CatalogServiceImpl();
    private final BrandService brandService = new BrandServiceImpl();

}
