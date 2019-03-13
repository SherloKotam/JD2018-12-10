package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getString(req, "login", Patterns.LOGIN);
            String password = Form.getString(req, "password", Patterns.PASSWORD);
            Dao dao = Dao.getDao();
            String sqlWhere = String.format("WHERE `login`='%s'", login);
            List<User> users = dao.user.getAll(sqlWhere);
            if (users.size() > 0) {
                User user = users.get(0);
                if (user.getPassword().equals(password)) {
                    Cookie cookie = new Cookie("login", user.getLogin());
                    cookie.setMaxAge(24*60*60);
                    resp.addCookie(cookie);
                    cookie = new Cookie("hash", Utils.getHash(user));
                    cookie.setMaxAge(24*60*60);
                    resp.addCookie(cookie);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    if (user.getFk_roles() == 1)
                        return Action.ADMINPANELPROFILE;
                    if (user.getFk_roles() == 2)
                        return Action.PROFILE;
                    else return Action.ERROR;
                } else {
                    req.setAttribute("incorrectPass", "Password is incorrect");
                    return Action.LOGIN;
                }
            } else {
                req.setAttribute("noUser", "There is no user with this login");
                return Action.LOGIN;
            }
        }
        return Action.LOGIN;
    }
}
