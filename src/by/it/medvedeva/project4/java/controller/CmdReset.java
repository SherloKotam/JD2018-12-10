package by.it.medvedeva.project4.java.controller;

import by.it.medvedeva.project4.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {

        Dao.getDao().reset();


        return Action.INDEX;
    }
}
