package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdOrder implements Cmd {

    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.findUser(req);
        DAO dao = DAO.getDao();
        if (user == null)
            return Action.LOGIN;
        if (Form.isPost(req)) {
            req.getSession().setMaxInactiveInterval(10 * 60);
            Order order = new Order();
            order.setMenu_id(dao.menu.getAll(" WHERE `name`='" + Form.getString(req, "dish") +
                    "'").get(0).getId());
            order.setCount(Form.getInt(req, "count"));
            order.setCheck(Form.getInt(req, "count") * dao.menu.getAll(" WHERE `name`='" + Form.getString(req, "dish") +
                    "'").get(0).getPrice());
            order.setUsers_id(user.getId());
            if (DAO.getDao().order.create(order))
                return Action.RESTAURANT;
        }

        req.getSession().setMaxInactiveInterval(10 * 60);
        List<Menu> menu = dao.menu.getAll();
        req.setAttribute("menu", menu);

        return Action.ORDER;
    }
}
