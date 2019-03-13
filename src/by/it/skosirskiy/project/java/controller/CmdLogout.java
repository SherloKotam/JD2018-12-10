package by.it.skosirskiy.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        req.getSession().invalidate();
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        Cookie cookie = new Cookie("login", "");
        cookie.setMaxAge(-1);
        Util.setCookie(req, cookie);
        return Action.LOGIN;
    }
}
