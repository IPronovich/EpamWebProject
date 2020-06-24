package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogShower implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        List<Catalog> catalog = null;
        String id = req.getParameter("id");
        if (id == null) {
            catalog = getMainCategory(req);
        } else {
            catalog = getCategoryById(req, id);
        }
        if (catalog.isEmpty()) {
            resp.sendRedirect("/product?categoryId=" + id);
        } else {
            servletContext.getRequestDispatcher(JspPathUtil.get("catalog")).forward(req, resp);
        }
    }

    private List<by.epam.pronovich.model.Catalog> getCategoryById(HttpServletRequest req, String id) {
        List<by.epam.pronovich.model.Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getCategorysByParentId(Integer.valueOf(id));
        req.setAttribute("catalog", catalog);
        return catalog;
    }

    private List<by.epam.pronovich.model.Catalog> getMainCategory(HttpServletRequest req) {
        List<by.epam.pronovich.model.Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getAllMainCategory();
        req.setAttribute("catalog", catalog);
        return catalog;
    }
}
