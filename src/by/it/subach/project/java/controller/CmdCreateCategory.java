package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.Category;
import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateCategory implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            if (req.getParameter("cancel") != null) {
                return Action.ADMIN;
            } else if (req.getParameter("ok") != null) {

                String name = Form.getString(req, "name");
                String description = Form.getString(req, "description");
                DAO dao = DAO.getInstance();
                Category category = new Category(0, name, description);
                if (dao.category.create(category))
                    return Action.CATALOG;
            }
        }
        return Action.CREATECATEGORY;
    }
}
