package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        if (user.getFk_roles() == 2) return Action.PROFILE;
        if (user.getFk_roles() != 1) return Action.INDEX;
        Dao dao = Dao.getDao();
        if (req.getMethod().equalsIgnoreCase("post")) {
            User editedUser = new User();
            if (req.getParameter("delete") != null) {
                editedUser.setId(Form.getLong(req, "id"));
                dao.user.delete(editedUser);
                req.getServletContext().setAttribute("users", dao.user.getAll());
                return Action.EDITUSERS;
            } else if (req.getParameter("edit") != null) {
                editedUser.setId(Form.getLong(req, "id"));
                editedUser.setCashier(Form.getDouble(req, "cashier"));
                editedUser.setLogin(Form.getString(req, "login", Patterns.LOGIN));
                editedUser.setEmail(Form.getString(req, "email", Patterns.EMAIL));
                editedUser.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                editedUser.setFk_roles(Form.getLong(req, "role"));
                dao.user.update(editedUser);
                req.getServletContext().setAttribute("users", dao.user.getAll());
                return Action.EDITUSERS;
            } else if (req.getParameter("create") != null) {
                String login = Form.getString(req, "login", Patterns.LOGIN);
                String where = String.format("WHERE `login`='%s'", login);
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    String error = "User with login \"" + login + "\" already exists<br>";
                    req.setAttribute("loginExists", error);
                    return Action.EDITUSERS;
                } else {
                    editedUser.setLogin(login);
                    editedUser.setEmail(Form.getString(req, "email", Patterns.EMAIL));
                    editedUser.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                    editedUser.setFk_roles(Form.getLong(req, "role"));
                    editedUser.setCashier(Form.getDouble(req, "cashier"));
                    dao.user.create(editedUser);
                    req.getServletContext().setAttribute("users", dao.user.getAll());
                    return Action.EDITUSERS;
                }
            }
        }
        req.setAttribute("users", dao.user.getAll());
        return Action.EDITUSERS;
    }
}
