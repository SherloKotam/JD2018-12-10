package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Role;
import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdViewUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        List<User> users = DAO.getInstance().user.getAll();
        req.setAttribute("users", users);

        List<Role> roles = DAO.getInstance().role.getAll();
        req.setAttribute("roles", roles);
        return Action.VIEWUSERS;
    }
}
