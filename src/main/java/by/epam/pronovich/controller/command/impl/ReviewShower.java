package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReviewShower implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Review> reviews = ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(id));
        req.setAttribute("reviews", reviews);
        req.setAttribute("prod_id", id);
        servletContext.getRequestDispatcher(JspPathUtil.get("review")).forward(req, resp);
    }
}
