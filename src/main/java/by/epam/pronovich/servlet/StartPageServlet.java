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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/olener")
public class StartPageServlet extends HttpServlet {
    private final int QUANTITY_OF_RANDOM_PRODUCTS_ON_START_PAGE = 8;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getRandomProducts(req);
        getServletContext().getRequestDispatcher(JspPathUtil.get("start-page")).forward(req, resp);
    }

    private void getRandomProducts(HttpServletRequest req) {
        List<Product> products = ServiceProvider.getINSTANCE().getProductService().getAll();
        Collections.shuffle(products);
        products = products.stream().limit(QUANTITY_OF_RANDOM_PRODUCTS_ON_START_PAGE).collect(Collectors.toList());
        req.setAttribute("products", products);
    }
}
