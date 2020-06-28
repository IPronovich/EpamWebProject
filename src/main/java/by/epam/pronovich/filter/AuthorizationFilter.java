package by.epam.pronovich.filter;

import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static by.epam.pronovich.model.Role.ADMIN;

@WebFilter(servletNames = {"AdminServlet"})
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (isUserAdmin(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/authentication");
        }
    }

    private boolean isUserAdmin(ServletRequest servletRequest) {
        Customer customer = (Customer) ((HttpServletRequest) servletRequest).getSession().getAttribute("customer");
        return (Objects.nonNull(customer) && customer.getRole().equals(ADMIN));
    }
}
