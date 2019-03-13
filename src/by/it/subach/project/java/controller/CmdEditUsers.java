package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Role;
import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        if(Form.isPost(req)){
            long id = Form.getLong(req, "id");
            String login = Form.getString(req, "login");
            String email = Form.getString(req, "email");
            String password = Form.getString(req, "password");
            long role_id = Form.getLong(req, "role_id");

            User user = new User(id, login, email, password, role_id);
            if(req.getParameter("update") != null){
                dao.user.update(user);
            }
            else if(req.getParameter("delete") != null){
                dao.user.delete(user);
            }
        }
        List<User> users = DAO.getInstance().user.getAll();
        req.setAttribute("users", users);

        List<Role> roles = DAO.getInstance().role.getAll();
        req.setAttribute("roles", roles);
        return Action.EDITUSERS;
    }
}
