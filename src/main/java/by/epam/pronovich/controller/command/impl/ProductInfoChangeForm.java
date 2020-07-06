package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInfoChangeForm implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        Product product = ServiceProvider.getINSTANCE().getProductService().getById(Integer.valueOf(productId));
        List<Catalog> catalogList = ServiceProvider.getINSTANCE().getCatalogService().getAllSubCategory();
        List<Brand> brands = ServiceProvider.getINSTANCE().getBrandService().getAll();
        req.setAttribute("catalog", catalogList);
        req.setAttribute("brands", brands);
        req.setAttribute("product", product);
        servletContext.getRequestDispatcher(JspPathUtil.get("change-product-info")).forward(req, resp);
    }
}
