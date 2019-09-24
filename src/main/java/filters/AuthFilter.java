package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/MyAccountServlet")
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        if (session.getAttribute("email") !=null && session.getAttribute("password") !=null) {
            chain.doFilter(req, resp);
            response.sendRedirect("/account.jsp");
        } else {
            response.sendRedirect("/user-not-valid.jsp");
        }
    }

    public void destroy() {
    }
}