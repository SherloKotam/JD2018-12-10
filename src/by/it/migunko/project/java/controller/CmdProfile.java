package by.it.migunko.project.java.controller;

import by.it.migunko.project.java.beans.Tours;
import by.it.migunko.project.java.beans.User;
import by.it.migunko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;


class CmdProfile implements Cmd {
    @Override
   public Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null){
            return Action.LOGIN;
        }

        User user = (User) oUser;

        if (Util.isPost(req)){
            if (req.getParameter("update") != null){
                String login = Util.getString(req, "login");
                String email = Util.getEmail(req, "email");
                String password = Util.getString(req, "password");
                user.setLogin(login);
                user.setEmail(email);
                user.setPassword(password);
                Dao.getDao().user.update(user);
            }
            else if (req.getParameter("logout") != null){
                session.invalidate();
                return Action.LOGIN;
            }
        }

        String where = String.format( " WHERE users_id=%d", user.getId());
        List<Tours> tours = Dao.getDao().tours.getAll(where);
        req.setAttribute("tours", tours);
        return null;
    }
}
