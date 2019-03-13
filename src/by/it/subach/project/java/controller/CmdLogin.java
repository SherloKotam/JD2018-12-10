package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            DAO dao = DAO.getInstance();
            String where = String.format(" WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<User> users = dao.user.getAll(where);
            if(users.size() > 0){
                User user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                Cookie cookie = new Cookie("hash", Util.getHash(user));
                cookie.setMaxAge(24*60*60);
                Util.setCookie(req, cookie);
                cookie = new Cookie("login", user.getLogin());
                cookie.setMaxAge(24*60*60);
                Util.setCookie(req, cookie);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
