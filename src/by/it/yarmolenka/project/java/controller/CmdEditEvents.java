package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Bet;
import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdEditEvents implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        if (user.getFk_roles() == 2) return Action.PROFILE;
        if (user.getFk_roles() != 1) return Action.INDEX;
        long raceEv = Form.getLong(req, "raceEv");
        if (raceEv > 0) {
            Dao dao = Dao.getDao();
            if (Form.getString(req, "edit") != null) {
                Event editedEvent = new Event(
                        Form.getLong(req, "id"),
                        Form.getString(req, "description", Patterns.TEXT),
                        Form.getDouble(req, "odds"),
                        raceEv
                );
                dao.event.update(editedEvent);
            } else if (Form.getString(req, "delete") != null) {
                long id = Form.getLong(req, "id");
                String where = String.format("WHERE `fk_events`='%d'", id);
                List<Bet> bets = dao.bet.getAll(where);
                if (bets.size() == 0) {
                    Event editedEvent = new Event();
                    editedEvent.setId(id);
                    dao.event.delete(editedEvent);
                } else {
                    req.setAttribute("noDel", "Can not delete event while there are bets on it");
                }
            } else if (Form.getString(req, "create") != null) {
                Event editedEvent = new Event();
                editedEvent.setDescription(Form.getString(req, "description", Patterns.TEXT));
                editedEvent.setOdds(Form.getDouble(req, "odds"));
                editedEvent.setFk_races(raceEv);
                dao.event.create(editedEvent);
            }
            String where = String.format("WHERE `fk_races`='%d'", raceEv);
            List<Event> events = dao.event.getAll(where);
            String where2 = String.format("WHERE `id`='%d'", raceEv);
            List<Race> races = dao.race.getAll(where2);
            req.setAttribute("raceEv", raceEv);
            req.setAttribute("curRace", races.get(0));
            req.setAttribute("events", events);
            return Action.EDITEVENTS;
        }
        return Action.EDITRACES;
    }
}
