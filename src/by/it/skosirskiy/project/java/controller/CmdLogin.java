package by.it.skosirskiy.project.java.controller;

import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {

        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password","[a-zA-Z0-9_-]{5,}");
            Dao dao = Dao.getDao();
            String where = String.format(
                    " WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session= req.getSession(true);
                session.setMaxInactiveInterval(30); // время жизни сессии(30 сек)
                User user = users.get(0);
                session.setAttribute("user",user);
                req.setAttribute("user",user);
                Cookie cookie = new Cookie("hash", Util.getHash(user));
                cookie.setMaxAge(60);
                Util.setCookie(req, cookie);
                cookie = new Cookie("login", user.getLogin());
                cookie.setMaxAge(60);
                Util.setCookie(req, cookie);
                return Action.PROFILE;
            }

        }

        return Action.LOGIN;
    }
}
