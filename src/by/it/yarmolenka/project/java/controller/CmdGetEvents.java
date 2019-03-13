package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdGetEvents implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String raceEv = req.getParameter("raceEv");
        if (raceEv != null){
            Dao dao = Dao.getDao();
            String where = String.format("WHERE `fk_races`='%d'", Long.parseLong(raceEv));
            List<Event> events = dao.event.getAll(where);
            req.setAttribute("events", events);
            req.setAttribute("races", dao.race.getAll());
            return Action.GETEVENTS;
        }
        return Action.GETEVENTS;
    }
}
