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

public class ProductInfoShowing implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = ServiceProvider.getINSTANCE().getProductService().getById(Integer.valueOf(id));
        req.setAttribute("product", product);
        req.setAttribute("count_review", getCountOfReview(id));
        servletContext.getRequestDispatcher(JspPathUtil.get("product-info")).forward(req, resp);
    }

    private int getCountOfReview(String id) {
        return ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(id)).size();
    }
}
