package filter;

import Entity.User;
import Utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith(request.getContextPath() + "/Profile")) {
            User user = (User) SessionUtils.getInstance().getValue(request, "user");
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
               response.sendRedirect(request.getContextPath() + "/LoginController");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);

        }

    }

}
