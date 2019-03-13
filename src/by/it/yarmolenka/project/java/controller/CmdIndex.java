package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Race> races = Dao.getDao().race.getAll();
        req.setAttribute("races", races);
        return Action.INDEX;
    }
}
