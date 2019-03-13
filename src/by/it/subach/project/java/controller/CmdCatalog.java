package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCatalog implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        List<Category> categories = dao.category.getAll();
        req.setAttribute("categories", categories);


        String categoryId = req.getParameter("category");
        if(categoryId != null){
            long id = Long.parseLong(categoryId);
            String where = String.format(" WHERE `categories_id`=" + id);
            List<Product> products = dao.product.getAll(where);
            req.setAttribute("products", products);
        }

        return Action.CATALOG;
    }
}
