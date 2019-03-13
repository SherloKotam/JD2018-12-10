package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.Role;
import by.it.lyakhova.project.java.bean.User;
import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        Dao dao = Dao.getDao();
        User user = Util.findUser(request);
        if (user==null)
            return Action.LOGIN;

        if (Form.isPost(request)){
            long id = Form.getLong(request, "id");
            String login = Form.getString(request, "login");
            String password = Form.getString(request, "password");
            String email = Form.getString(request, "email");
            String contacts = Form.getString(request, "contacts");//"+([0-9]{12})"
            long roles_id = Form.getLong(request, "roles_id");

            user = new User(id, login, password, email, contacts, roles_id);
            if (request.getParameter("update")!=null){
                dao.user.update(user);
            }
            else if (request.getParameter("delete")!=null){
                dao.user.delete(user);
            }
        }
        
        List<User> users = Dao.getDao().user.getAll();
        request.setAttribute("users", users);
        List<Role> roles = Dao.getDao().role.getAll();
        request.setAttribute("roles", roles);
        return Action.EDITUSERS;
    }
}
