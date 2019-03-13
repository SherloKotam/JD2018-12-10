package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        Dao dao = Dao.getDao();
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("edit") != null) {
                String login = Form.getString(req, "login", Patterns.LOGIN);
                List<User> users = dao.user.getAll();
                for (User user1 : users)
                    if (!user1.getLogin().equalsIgnoreCase(login)){
                        req.setAttribute("userExists", "user " + login + " already exists<br>");
                        return Action.PROFILE;
                    }

                String email = Form.getString(req, "email", Patterns.EMAIL);
                user.setLogin(login);
                user.setEmail(email);
                dao.user.update(user);
                return Action.PROFILE;
            } else if (req.getParameter("delete") != null) {
                req.setAttribute("confirmDelete", "");
                return Action.PROFILE;
            } else if (req.getParameter("deleteConfirmed") != null) {
                req.getSession().invalidate();
                Cookie cookie = new Cookie("login", "");
                resp.addCookie(cookie);
                dao.user.delete(user);
                return Action.LOGIN;
            }
        }
        String where = String.format("WHERE `fk_users`='%d'", user.getId());
        HttpSession session = req.getSession();
        session.setAttribute("events", dao.event.getAll());
        session.setAttribute("races", dao.race.getAll());
        session.setAttribute("userBets", dao.bet.getAll(where));
        return Action.PROFILE;
    }
}
