package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdAdminPanelProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws ProjectException, SQLException {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        if (user.getFk_roles() == 2) return Action.PROFILE;
        Dao dao = Dao.getDao();
        if (user.getFk_roles() == 1) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("edit") != null) {
                    String login = Form.getString(req, "login", Patterns.LOGIN);
                    List<User> users = dao.user.getAll();
                    for (User user1 : users)
                        if (user1.getLogin().equalsIgnoreCase(login)){
                            req.setAttribute("userExists", "user " + login + " already exists<br>");
                            return Action.ADMINPANELPROFILE;
                        }
                    String email = Form.getString(req, "email", Patterns.EMAIL);
                    user.setLogin(login);
                    user.setEmail(email);
                    dao.user.update(user);
                    return Action.ADMINPANELPROFILE;
                } else if (req.getParameter("delete") != null) {
                    req.setAttribute("confirmDelete", "");
                    return Action.ADMINPANELPROFILE;
                } else if (req.getParameter("deleteConfirmed") != null) {
                    req.getSession().invalidate();
                    Cookie cookie = new Cookie("login", "");
                    resp.addCookie(cookie);
                    dao.user.delete(user);
                    return Action.LOGIN;
                }
            }
            return Action.ADMINPANELPROFILE;
        }
        return Action.LOGIN;
    }
}