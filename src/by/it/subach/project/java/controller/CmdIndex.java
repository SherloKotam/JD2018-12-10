package by.it.subach.project.java.controller;



import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        List<Product> products = dao.product.getAll();
        req.setAttribute("products", products);
        List<Category> categories = dao.category.getAll();
        req.setAttribute("categories", categories);
        return Action.INDEX;
    }
}
