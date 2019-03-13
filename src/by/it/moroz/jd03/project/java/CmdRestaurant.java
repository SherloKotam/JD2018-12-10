package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdRestaurant implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(Form.isPost(req)){
            return Action.ORDER;
        }
        req.getSession().setMaxInactiveInterval(10*60);
        List<Menu> menu = DAO.getDao().menu.getAll();
        req.setAttribute("menu", menu);
        User user = Util.findUser(req);
        if (user != null)
            req.getSession().setMaxInactiveInterval(30);
        return Action.RESTAURANT;
    }
}
