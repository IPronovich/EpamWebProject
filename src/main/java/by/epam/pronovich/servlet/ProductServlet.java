package by.epam.pronovich.servlet;

import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("category");
        List<Product> products = ServiceProvider.getINSTANCE().getProductService().getByCategoryId(Integer.valueOf(categoryId));
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher(JspPathUtil.get("product")).forward(req, resp);

    }
}
