package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Bet;
import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.beans.Race;
import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdBet implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        Dao dao = Dao.getDao();
        if (req.getMethod().equalsIgnoreCase("post")) {
            double betAmount = Form.getDouble(req, "amount");
            if (betAmount > user.getCashier()) {
                req.setAttribute("noMoney", "Not enough money<br>");
            } else {
                Bet newBet = new Bet();
                newBet.setAmount(Form.getDouble(req, "amount"));
                newBet.setFk_events(Form.getLong(req, "fk_events"));
                newBet.setFk_users(Form.getLong(req, "fk_users"));
                newBet.setPayout(0);
                if (dao.bet.create(newBet)) {
                    user.setCashier(user.getCashier() - betAmount);
                    dao.user.update(user);
                    return Action.INDEX;
                }
            }
        }
        long eventId = Form.getLong(req, "EventId");
        String where = String.format("WHERE `id`='%d'", eventId);
        List<Event> events = dao.event.getAll(where);
        Event event = new Event();
        if (events.size() > 0)
            event = events.get(0);
        req.setAttribute("event", event);
        String where2 = String.format("WHERE `id`='%d'", event.getFk_races());
        List<Race> races = dao.race.getAll(where2);
        if (races.size() > 0)
            req.setAttribute("raceDescription", races.get(0).getDescription());
        return Action.BET;
    }
}
