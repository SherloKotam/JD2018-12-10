package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

class CmdEditRaces implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        if (user.getFk_roles() == 2) return Action.PROFILE;
        if (user.getFk_roles() != 1) return Action.INDEX;
        Dao dao = Dao.getDao();
        if (req.getMethod().equalsIgnoreCase("post")) {
            Race editedRace = new Race();
            if (Form.getString(req, "delete") != null) {
                List<Event> events = dao.event.getAll();
                long id = Form.getLong(req, "id");
                for (Event event : events) {
                    if (event.getFk_races() == id) {
                        req.setAttribute("cannotDeleteRace", "cannot delete race until this race's events are not deleted");
                        req.setAttribute("delId", id);
                        req.setAttribute("races", dao.race.getAll());
                        return Action.EDITRACES;
                    }
                }
                editedRace.setId(Form.getLong(req, "id"));
                dao.race.delete(editedRace);
            } else if (Form.getString(req, "edit") != null) {
                editedRace.setId(Form.getLong(req, "id"));
                editedRace.setDescription(Form.getString(req, "description", Patterns.TEXT));
                editedRace.setRace_track(Form.getString(req, "race_track", Patterns.TEXT));
                Timestamp timestamp = Utils.getDateTimestamp(req);
                editedRace.setDate(timestamp);
                dao.race.update(editedRace);
            } else if (Form.getString(req, "create") != null) {
                editedRace.setDescription(Form.getString(req, "description", Patterns.TEXT));
                editedRace.setRace_track(Form.getString(req, "race_track", Patterns.TEXT));
                Timestamp timestamp = Utils.getDateTimestamp(req);
                editedRace.setDate(timestamp);
                dao.race.create(editedRace);
            }
        }
        setDates(req, dao);
        return Action.EDITRACES;
    }

    private void setDates(HttpServletRequest req, Dao dao) throws SQLException {
        List<Race> races = dao.race.getAll();
        String[] dates = new String[(int) races.get(races.size()-1).getId()];
        for (Race race : races) dates[(int) race.getId()-1] = Utils.getStringDate(race);
        req.setAttribute("races", dao.race.getAll());
        req.setAttribute("dates", dates);
    }
}