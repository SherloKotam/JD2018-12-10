package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String email = Form.getString(req, "email", "[a-zA-Z0-9._-]{5,}@[a-zA-Z-]{2,}.[a-z]{2,}");
            String password = Form.getString(req, "password", "[A-Za-z0-9_-]{5,}");
            DAO dao = DAO.getDao();
            String where = String.format(
                    " WHERE `email`='%s' AND `password`='%s'",
                    email, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                User user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                Cookie cookie = new Cookie("hash", Util.getHash(user));
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);
                cookie = new Cookie("login", user.getLogin());
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);
                return Action.RESTAURANT;
            }
        }
        return Action.LOGIN;
    }
}
