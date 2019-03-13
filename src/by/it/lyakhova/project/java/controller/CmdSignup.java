package by.it.lyakhova.project.java.controller;


import by.it.lyakhova.project.java.bean.User;
import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {

    @Override
    public Action execute(HttpServletRequest request) throws Exception {

        if (Form.isPost(request)){
            String login = Form.getString(request, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(request, "password");//"[a-zA-Z0-9]{6,}"
            String email = Form.getString(request, "email");//"([A-Za-z0-9._-]+)@([a-z]{2,}).([a-z]{2,4})"
            String contacts = Form.getString(request, "contacts");//"+([0-9]{12})"

            User user = new User(0, login, password, email, contacts, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user)){
                return Action.LOGIN;
            }
        }
        return Action.SIGNUP;
    }
}
