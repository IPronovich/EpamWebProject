package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.service.sorting.SortingName;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductsShower implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        req.setAttribute("categoryId", categoryId);
        List<Product> products = ServiceProvider.getINSTANCE().getProductService().getByCategoryId(Integer.valueOf(categoryId));
        products = sort(req, products);
        req.setAttribute("products", products);
        servletContext.getRequestDispatcher(JspPathUtil.get("product")).forward(req, resp);
    }

    private List<Product> sort(HttpServletRequest req, List<Product> products) {
        String order = req.getParameter("order");
        SortingName[] values = SortingName.values();
        req.setAttribute("orderList", values);
        if (order != null) {
            products = ServiceProvider.getINSTANCE().getProductService().sort(products, order);
        }
        return products;
    }
}
