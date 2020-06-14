package by.epam.pronovich.servlet;

import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showCatalog(req, resp);
    }

    private void showCatalog(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Catalog> catalog = null;
        String id = req.getParameter("id");
        if (id == null) {
            catalog = getMainCategory(req);
        } else {
            catalog = getCategoryById(req, id);
        }
        if (catalog.isEmpty()) {
            resp.sendRedirect("/product?category=" + id);
        } else {
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("catalog")).forward(req, resp);
        }
    }

    private List<Catalog> getCategoryById(HttpServletRequest req, String id) {
        List<Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getCategorysByParentId(Integer.valueOf(id));
        req.setAttribute("catalog", catalog);
        return catalog;
    }

    private List<Catalog> getMainCategory(HttpServletRequest req) {
        List<Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getAllMainCategory();
        req.setAttribute("catalog", catalog);
        return catalog;
    }
}
