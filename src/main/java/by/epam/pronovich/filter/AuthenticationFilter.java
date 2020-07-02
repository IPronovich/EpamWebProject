package by.epam.pronovich.filter;

import by.epam.pronovich.model.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"BasketServlet","ReviewServlet"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (isUserAuthenticate(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/authentication");
        }
    }

    private boolean isUserAuthenticate(ServletRequest servletRequest) {
        Customer customer = (Customer) ((HttpServletRequest) servletRequest).getSession().getAttribute("customer");
        return Objects.nonNull(customer);
    }
}
