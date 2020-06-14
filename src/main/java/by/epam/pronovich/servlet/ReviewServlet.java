package by.epam.pronovich.servlet;

import by.epam.pronovich.controller.Controller;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Review> reviews = ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(id));
        req.setAttribute("reviews", reviews);
        req.setAttribute("prod_id", id);

        getServletContext().getRequestDispatcher(JspPathUtil.get("review")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Controller.getINSTANCE().doAction(req, resp, servletContext);
    }


}
