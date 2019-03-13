package by.it.skosirskiy.project.java.controller;



import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;


public class CmdIndex implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Request> requests = Dao.getDao().request.getAll("");
        req.setAttribute("requests",requests);
        System.out.println(requests);
        return Action.INDEX;
    }
}
