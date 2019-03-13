package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdRegister implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getString(req, "login", Patterns.LOGIN);
            Dao dao = Dao.getDao();
            List<User> users = dao.user.getAll(String.format("WHERE `login`='%s'", login));
            if (users.size() > 0){
                String error = "User with login \"" + login + "\" already exists<br>";
                req.setAttribute("loginExists", error);
                return Action.REGISTER;
            } else{
                String email = Form.getString(req, "email", Patterns.EMAIL);
                String password = Form.getString(req, "password", Patterns.PASSWORD);
                String confirmPassword = Form.getString(req, "confirmPassword", Patterns.PASSWORD);
                if (password==null) return Action.REGISTER;
                if (!password.equals(confirmPassword)){
                    req.setAttribute("passNotMatch", "password does not match<br>");
                    return Action.REGISTER;
                }
                User newUser = new User(0, login, email, password, 0, 2);
                if (dao.user.create(newUser)) {
                    req.getServletContext().setAttribute("users", dao.user.getAll());
                    req.getSession().setAttribute("user", newUser);
                    Cookie cookie = new Cookie("login", newUser.getLogin());
                    cookie.setMaxAge(24*60*60);
                    resp.addCookie(cookie);
                    cookie = new Cookie("hash", Utils.getHash(newUser));
                    cookie.setMaxAge(24*60*60);
                    resp.addCookie(cookie);
                    return Action.PROFILE;
                }
                else throw new ProjectException("Can not create user " + newUser);
            }
        }
        return Action.REGISTER;
    }
}
