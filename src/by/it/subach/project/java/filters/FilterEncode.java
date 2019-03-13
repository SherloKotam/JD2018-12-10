package by.it.subach.project.java.filters;


import javax.servlet.*;
import java.io.IOException;

public class FilterEncode implements Filter {

    String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encode != null) {
            if (!encode.equalsIgnoreCase(servletRequest.getCharacterEncoding()))
                servletRequest.setCharacterEncoding(encode);
            if (!encode.equalsIgnoreCase(servletResponse.getCharacterEncoding()))
                servletResponse.setCharacterEncoding(encode);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
