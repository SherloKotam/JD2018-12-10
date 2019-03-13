package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdProfile implements Cmd{
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DAO dao = DAO.getDao();
        if(Form.isPost(req)){
            if(req.getParameter("logout")!=null) {
                req.getSession().invalidate();
                Cookie cookie = new Cookie("login", "none");
                resp.addCookie(cookie);
                return Action.INDEX;
            }
            else{
                req.getSession().setMaxInactiveInterval(10*60);
                String email = Form.getString(req, "email", "[a-zA-Z0-9._-]{5,}@[a-zA-Z-]{2,}.[a-z]{2,}");
                String address = Form.getString(req, "address", "[а-яА-яA-Za-z]{3,},? [0-9]+[-][0-9]+");
                String name = Form.getString(req, "name", "[а-яА-яA-Za-z]{2,}");
                String surname = Form.getString(req, "surname", "[а-яА-яA-Za-z]{2,}");
                int numberphone = Form.getInt(req, "numberphone", "[0-9]{9,9}");
                User currentUser = Util.findUser(req);
                if(currentUser!=null) {
                    User user = new User(currentUser.getId(), currentUser.getLogin(), currentUser.getPassword(),
                            email, address, name, surname, numberphone, currentUser.getRoles_id());
                    dao.user.update(user);
                    if (currentUser.getId() == user.getId()) {
                        req.getSession().setAttribute("user", user);
                        return Action.PROFILE;
                    }
                }

            }
        }
        User user = Util.findUser(req);
        if(user!=null){
            long start = 0;
            if (req.getParameter("start") != null)
                start = Form.getLong(req, "start");
            req.setAttribute("user", user);
            req.getSession().setMaxInactiveInterval(10*60);
            String where=String.format("WHERE `users_id`='%d' LIMIT %d,5",user.getId(), start);
            List<Order> orders = dao.order.getAll(where);
            List<Menu> menu = dao.menu.getAll();
            req.setAttribute("orders",orders);
            req.setAttribute("menu", menu);
            where = String.format(" WHERE `users_id`='%d'", user.getId());
            int ordersCount = dao.order.getAll(where).size();
            req.setAttribute("ordersCount", ordersCount);
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
