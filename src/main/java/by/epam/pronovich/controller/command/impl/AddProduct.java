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

public class AddProduct implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        Product product = ServiceProvider.getINSTANCE().getProductService().save(getProductWithoutIdFrom(req));
        resp.sendRedirect("/product-info?id=" + product.getId());
    }

    private Product getProductWithoutIdFrom(HttpServletRequest req) {
        return Product.builder()
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
