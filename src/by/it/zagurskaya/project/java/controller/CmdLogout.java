package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        req.getSession().invalidate();
        Cookie cookie = new Cookie("login", "none");
        Util.setCookie(req, cookie);
        return Action.LOGIN;
    }
}
