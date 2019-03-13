package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Order;
import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCheckout implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            DAO dao = DAO.getInstance();
            User user = Util.findUser(req);
            if (user != null) {
                long userID = user.getId();
                String where = String.format(" WHERE `user_id`=%d", userID);
                List<Order> orders = dao.order.getAll(where);
                if (req.getParameter("payment") != null) {
                    for (Order order : orders) {
                        dao.order.delete(order);
                    }
                    String message = "Payment success!";
                    req.setAttribute("message", message);
                }
                else if(req.getParameter("cancel") != null){
                    return Action.CART;
                }
            }

        return Action.CHECKOUT;
    }
        return Action.INDEX;
}
}
