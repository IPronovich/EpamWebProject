package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductChangesSaver implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        Product product = getProductFrom(req);
        ServiceProvider.getINSTANCE().getProductService().update(product);
        resp.sendRedirect("/productInfo?id=" + product.getId());
    }

    private Product getProductFrom(HttpServletRequest req) {
        return Product.builder()
                .id(Integer.valueOf(req.getParameter("productId")))
                .catalog(Catalog.builder()
                        .id(Integer.valueOf(req.getParameter("catalogId"))).build())
                .brand(Brand.builder()
                        .id(Integer.valueOf(req.getParameter("brandId"))).build())
                .model(req.getParameter("model"))
                .description(req.getParameter("description"))
                .price(Double.valueOf(req.getParameter("price")))
                .img(req.getParameter("img"))
                .quantity(Integer.valueOf(req.getParameter("quantity")))
                .build();
    }
}
