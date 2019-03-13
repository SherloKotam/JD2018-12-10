package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Order;
import by.it.subach.project.java.beans.User;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdOrder implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        if(Form.isPost(req)){
            DAO dao = DAO.getInstance();
            Long product_id = Long.parseLong(req.getParameter("id"));
            User user = Util.findUser(req);
            if(user == null){
                return Action.LOGIN;
            }
            else {
                long user_id = user.getId();
                Order order = new Order(0, user_id, product_id);
                if(dao.order.create(order))
                    req.setAttribute("order", order);
                    return Action.CART;
            }
        }

        return Action.CART;
    }
}
