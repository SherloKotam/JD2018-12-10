package by.it.medvedeva.project4.java.controller;

import by.it.medvedeva.project4.java.beans.Ad;
import by.it.medvedeva.project4.java.beans.Housead;
import by.it.medvedeva.project4.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll();
        List<Housead> houseads = Dao.getDao().housead.getAll();
        req.setAttribute("ads", ads);
        req.setAttribute("houseads", houseads);


        return null;
    }
}