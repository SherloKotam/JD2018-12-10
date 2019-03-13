package by.it.lyakhova.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        request.getSession().invalidate();

        return Action.LOGIN;
    }
}
