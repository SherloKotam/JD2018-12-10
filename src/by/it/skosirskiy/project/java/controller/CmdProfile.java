package by.it.skosirskiy.project.java.controller;

import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        User user = Util.findUser(req);
        if (user != null) {
            String where=String.format(" WHERE `user_id`='%d'",user.getId());
            List<Request> requests = Dao.getDao().request.getAll(where);
            req.setAttribute("requests",requests);
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
