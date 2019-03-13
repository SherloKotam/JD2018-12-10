package by.it.zagurskaya.project.java.filters;


import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.Dao;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Auth implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        List<Cookie> cookieList = Optional.ofNullable(req.getCookies()).map(Arrays::asList).orElse(Collections.emptyList());
        String login = cookieList.stream().filter(c -> "login".equals(c.getName())).findAny().map(Cookie::getValue).orElse(null);
        String hash = cookieList.stream().filter(c -> "hash".equals(c.getName())).findAny().map(Cookie::getValue).orElse(null);

        if (login != null && hash != null) {
            String where = String.format(" WHERE login='%s'", login);

            try {
                List<User> users = new UserDao().getAll(where);
                if (users.size() == 1) {
                    User user = users.get(0);
                    String hash1 = Util.getHash(user);
                    if (hash1.equals(hash)) {
                        req.getSession().setAttribute("user", user);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
