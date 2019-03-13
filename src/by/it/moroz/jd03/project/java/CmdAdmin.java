package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Role;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdAdmin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DAO dao = DAO.getDao();
        if (Form.isPost(req)) {
            if(req.getParameter("logout")!=null) {
                req.getSession().invalidate();
                Cookie cookie = new Cookie("login", "none");
                resp.addCookie(cookie);
                return Action.INDEX;
            } else {
                req.getSession().setMaxInactiveInterval(10 * 60);
                long id = Form.getLong(req, "id");
                String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
                String email = Form.getString(req, "email", "[a-zA-Z0-9._-]{5,}@[a-zA-Z-]{2,}.[a-z]{2,}");
                String address = Form.getString(req, "address", "[а-яА-яA-Za-z]{3,}, [0-9]+[-][0-9]+");
                String name = Form.getString(req, "name", "[а-яА-яA-Za-z]{2,}");
                String surname = Form.getString(req, "surname", "[а-яА-яA-Za-z]{2,}");
                int number = Form.getInt(req, "numberphone", "[0-9]{9,9}");
                long roles_id = Form.getLong(req, "roles_id");
                User currentUser = dao.user.read(id);
                User user = null;
                if (currentUser != null) {
                    user = new User(id, login, currentUser.getPassword(), email, address, name, surname, number, roles_id);
                }
                if (req.getParameter("update") != null) {
                    dao.user.update(user);
                    if (currentUser != null && currentUser.getId() == user.getId()) {
                        req.getSession().setAttribute("user", user);
                    }
                } else if (req.getParameter("delete") != null) {
                    dao.user.delete(user);
                    if (currentUser != null && currentUser.getId() == user.getId()) {
                        req.getSession().setMaxInactiveInterval(10 * 60);
                        User admin = Util.findUser(req);
                        req.setAttribute("admin", admin);
                        List<User> users = dao.user.getAll();
                        req.setAttribute("users", users);
                        List<Role> roles = dao.role.getAll();
                        req.setAttribute("roles", roles);
                        return Action.ADMIN;
                    }
                }
            }
        }
        long start = 0;
        if (req.getParameter("start") != null)
            start = Form.getLong(req, "start");
        req.getSession().setMaxInactiveInterval(10*60);
        User admin = Util.findUser(req);
        req.setAttribute("admin", admin);
        String limit = String.format(" LIMIT %d,5", start);
        List<User> users = dao.user.getAll(limit);
        req.setAttribute("users", users);
        int usersCount = dao.user.getAll().size();
        req.setAttribute("usersCount", usersCount);
        List<Role> roles = dao.role.getAll();
        req.setAttribute("roles", roles);
        return Action.ADMIN;
    }
}
