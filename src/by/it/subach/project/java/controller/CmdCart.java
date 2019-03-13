package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Order;
import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CmdCart implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();

        User user = Util.findUser(req);
        if (user != null) {
            long userID = user.getId();
            String where = String.format(" WHERE `user_id`=%d", userID);
            List<Order> orders = dao.order.getAll(where);
            if (orders.size() == 0) {
                String message = "Your cart is empty";
                req.setAttribute("message", message);
            }

            req.setAttribute("orders", orders);

            double total = 0;
            List<Product> products = new ArrayList<>();
            for (Order order : orders) {
                long product_id = order.getProduct_id();
                String where1 = String.format(" WHERE id=%d",
                        product_id);
                Product product = dao.product.getAll(where1).get(0);
                products.add(product);
                total += product.getPrice();
            }
            req.setAttribute("total", total);
            req.setAttribute("products", products);

            if (req.getParameter("del") != null) {
                long order_id = Long.parseLong(req.getParameter("del"));
                for (Order order : orders) {
                    if (order_id == order.getId()) {
                        if(dao.order.delete(order))
                            return Action.ORDER;
                    }
                }

            }

            return Action.CART;
        }

        return Action.LOGIN;

    }
}
