package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProductsList implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        String id = req.getParameter("id");
        String where = String.format(" WHERE `categories_id`=%s", id);
        String where1 = String.format(" WHERE id=%s", id);

        List<Product> products = dao.product.getAll(where);
        req.setAttribute("products", products);

        List<Category> categories = dao.category.getAll(where1);
        if(categories.size() == 1){
            String categoryName = categories.get(0).getName();
            req.setAttribute("categoryName", categoryName);
        }

        return Action.PRODUCTSLIST;
    }
}
