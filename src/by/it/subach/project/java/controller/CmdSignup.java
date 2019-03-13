package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if(Form.isPost(req)){
            String email = Form.getString(req, "email");
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            User user = new User(0, login, email, password, 3);
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole_id(3);
            if(DAO.getInstance().user.create(user)){
                return Action.INDEX;
            }
        }
        return Action.SIGNUP;
    }
}
