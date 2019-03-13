package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.User;
import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if (Form.isPost(request)){
            String login = Form.getString(request, "login", "[a-zA-Z0-9_-]{5,}");
            String pasword = Form.getString(request, "password", "[a-zA-Z0-9]{6,}" );//"[a-zA-Z0-9]{6,}"
            Dao dao = Dao.getDao();
            String where = String.format(
                    " WHERE login= '%s' AND password = '%s'",
                    login, pasword);
            List<User> users = dao.user.getAll(where);
            if (users.size()>0){
                User user = users.get(0);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                Cookie cookie = new Cookie("hash", Util.getHash(user));
                Util.setCookie(request, cookie);
                cookie = new Cookie("login", user.getLogin());
                Util.setCookie(request, cookie);

                return Action.INDEX;
            }
        }
        return Action.LOGIN;
    }
}
