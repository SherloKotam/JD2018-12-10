package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateUser implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            DAO dao = DAO.getInstance();
            String login = Form.getString(req, "login");
            String email = Form.getString(req, "email");
            String password = Form.getString(req, "password");
            long role_id = Form.getLong(req, "role");

            User user = new User(0, login, email, password, role_id);

            if(dao.user.create(user))
                return Action.VIEWUSERS;
        }
        return Action.CREATEUSER;
    }
}
