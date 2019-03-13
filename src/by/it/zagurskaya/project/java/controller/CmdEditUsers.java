package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)){
            long id = Form.getLong(req, "id");
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            long roleId = Form.getLong(req, "roleId");
            User user = new User(id, login, password, roleId);
            if (req.getParameter("update")!=null){
                new UserDao().update(user);
            }
            else if (req.getParameter("delete")!=null){
                new UserDao().delete(user);
            }
        }

        List<User> users = new ArrayList<User>();
        UserDao userDao = new UserDao();
        users.addAll(userDao.getAll());
        req.setAttribute("users",users);

        return Action.EDITUSERS;
    }
}
