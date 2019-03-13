package by.it.migunko.project.java.controller;

import by.it.migunko.project.java.beans.Tours;
import by.it.migunko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Tours> tours = Dao.getDao().tours.getAll("");
        req.setAttribute("tours", tours);
        return null;
    }
}
