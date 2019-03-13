package by.it.lyakhova.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class FilterImages implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestURI = req.getRequestURI();
        String[] partURI = requestURI.split("/");
        String filename = partURI[partURI.length - 1];
        String realPath = req.getServletContext().getRealPath("/images/" + filename);
        resp.setContentType("image");
        if (new File(realPath).exists()){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/images/no.png");
            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
