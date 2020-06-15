package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StartPageLoading implements Command {
    private final int QUANTITY_OF_RANDOM_PRODUCTS_ON_START_PAGE = 8;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        getRandomProducts(req);
        servletContext.getRequestDispatcher(JspPathUtil.get("start-page")).forward(req, resp);
    }

    private void getRandomProducts(HttpServletRequest req) {
        List<Product> products = ServiceProvider.getINSTANCE().getProductService().getAll();
        Collections.shuffle(products);
        products = products.stream().limit(QUANTITY_OF_RANDOM_PRODUCTS_ON_START_PAGE).collect(Collectors.toList());
        req.setAttribute("products", products);
    }
}
