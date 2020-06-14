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

@WebServlet("/product-info")
public class ProductInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = ServiceProvider.getINSTANCE().getProductService().getById(Integer.valueOf(id));
        req.setAttribute("product", product);
        req.setAttribute("count_review", getCountOfReview(id));

        getServletContext().getRequestDispatcher(JspPathUtil.get("product-info")).forward(req, resp);
    }

    private int getCountOfReview(String id) {
        return ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(id)).size();
    }
}
