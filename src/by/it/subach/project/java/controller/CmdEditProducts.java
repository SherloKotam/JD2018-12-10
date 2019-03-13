package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.beans.Product;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditProducts implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();

        if(Form.isPost(req)){
            long id = Form.getLong(req, "id");
            String name = Form.getString(req, "name");
            double price = Form.getDouble(req, "price");
            String description = Form.getString(req, "description");
            long categories_id = Form.getLong(req, "categories_id");

            Product product = new Product(id, name, price, description, categories_id);
            if(req.getParameter("update") != null){
                dao.product.update(product);
            }
            else if(req.getParameter("delete") != null){
                dao.product.delete(product);
            }
        }

        List<Product> products = dao.product.getAll();
        req.setAttribute("products", products);
        List<Category> categories = dao.category.getAll();
        req.setAttribute("categories", categories);
        return Action.EDITPRODUCTS;
    }
}
