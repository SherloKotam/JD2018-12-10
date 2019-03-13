package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSighUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException, SQLException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password", "[A-Za-z0-9_-]{5,}");
            String email = Form.getString(req, "email", "[a-zA-Z0-9._-]{5,}@[a-zA-Z-]{2,}.[a-z]{2,}");
            String address = Form.getString(req, "address", "[а-яА-яA-Za-z]{3,},? [0-9]+[-][0-9]+");
            String name = Form.getString(req, "name", "[а-яА-яA-Za-z]{2,}");
            String surname = Form.getString(req, "surname", "[а-яА-яA-Za-z]{2,}");
            int number = Form.getInt(req, "numberphone", "[0-9]{9,9}");
            User user = new User(0, login, password, email, address, name, surname, number, 2);
            DAO dao = DAO.getDao();
            if (dao.user.create(user)) {
                return Action.LOGIN;
            }
        }
        return Action.SIGNUP;
    }
}
