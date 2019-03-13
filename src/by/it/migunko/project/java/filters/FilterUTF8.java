package by.it.migunko.project.java.filters;


import javax.servlet.*;
import java.io.IOException;

public class FilterUTF8 implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String encoding = request.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(encode))
            request.setCharacterEncoding(encode);
        encoding = response.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(encode))
            response.setCharacterEncoding(encode);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
