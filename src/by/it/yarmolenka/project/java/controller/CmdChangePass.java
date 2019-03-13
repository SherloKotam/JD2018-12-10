package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdChangePass implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String oldPass = Form.getString(req, "oldPass", Patterns.PASSWORD);
            User user = Utils.getUser(req);
            if (user == null) return Action.LOGIN;
            if (user.getPassword().equals(oldPass)) {
                String newPass = Form.getString(req, "newPass", Patterns.PASSWORD);
                String confirmPass = Form.getString(req, "confirmPass", Patterns.PASSWORD);
                if (newPass != null) {
                    if (newPass.equals(confirmPass)) {
                        user.setPassword(newPass);
                        Dao dao = Dao.getDao();
                        dao.user.update(user);
                        req.getServletContext().setAttribute("users", dao.user.getAll());
                        return Action.ADMINPANELPROFILE;
                    } else {
                        req.setAttribute("passNotMatch", "password does not match<br>");
                        return Action.CHANGEPASS;
                    }
                }
            } else {
                req.setAttribute("incorrectPass", "Password is incorrect<br>");
                return Action.CHANGEPASS;
            }
        }
        return Action.CHANGEPASS;
    }
}
