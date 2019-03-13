package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Dao dao = Dao.getDao();
        dao.resetDatabase();
        Utils.setServletContextAttributes(req.getServletContext());
        return Action.INDEX;
    }
}
