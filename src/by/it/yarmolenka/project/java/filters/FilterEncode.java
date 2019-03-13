package by.it.yarmolenka.project.java.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class FilterEncode implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig filterConfig){
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
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
