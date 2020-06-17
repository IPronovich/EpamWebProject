package by.epam.pronovich.servlet;

import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(JspPathUtil.get("basket")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        voidAddToBasket(req, resp, command);


        if ("delete_product_from_basket".equals(command)) {
            String productId = req.getParameter("productId");
            HttpSession session = req.getSession();
            List<Product> basket = (ArrayList<Product>) session.getAttribute("basket");
            basket.removeIf(it -> it.getId().equals(Integer.valueOf(productId)));
            req.getSession().setAttribute("basket", basket);
            calculateSum(basket, session);
            getServletContext().getRequestDispatcher(JspPathUtil.get("basket")).forward(req, resp);
        }

    }


    private void voidAddToBasket(HttpServletRequest req, HttpServletResponse resp, String command) throws IOException {
        List<Product> basket = null;
        if ("add_to_basket".equals(command)) {
            Integer prodId = Integer.valueOf(req.getParameter("productId"));
            HttpSession session = req.getSession();
            basket = (ArrayList<Product>) session.getAttribute("basket");
            if (basket == null) {
                basket = new ArrayList<>();
            }
            basket.add(ServiceProvider.getINSTANCE().getProductService().getById(prodId));
            calculateSum(basket, session);
            session.setAttribute("basket", basket);


            for (Product product : basket) {
                System.out.println(product.getBrand() + " " + product.getModel());
            }
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    private void calculateSum(List<Product> basket, HttpSession session) {
        Double sum = basket.stream().mapToDouble(Product::getPrice).sum();
        session.setAttribute("sum", sum);
    }
}
