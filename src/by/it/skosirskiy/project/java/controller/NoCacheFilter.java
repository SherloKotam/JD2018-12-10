package by.it.skosirskiy.project.java.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filter) throws IOException, ServletException {
        {

            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
            resp.setHeader("Pragma", "no-cache");
            filter.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
