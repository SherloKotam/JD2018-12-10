package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Bet;
import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdEditBets implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long userId = Form.getLong(req, "userId");
        Dao dao = Dao.getDao();
        /*if (req.getMethod().equalsIgnoreCase("post")) {
            if (Form.getString(req, "edit") != null) {
                Bet bet = new Bet();
                bet.setId(Form.getLong(req, "id"));
                bet.setPayout(Form.getDouble(req, "payout"));
                bet.setAmount(Form.getDouble(req, "amount"));
                dao.bet.update(bet);
            } else if (Form.getString(req, "delete") != null) {
                Bet bet = new Bet();
                bet.setId(Form.getLong(req, "id"));
                dao.bet.delete(bet);
            }
        }*/
        String where = String.format("WHERE `id`='%d'", userId);
        List<User> users = dao.user.getAll(where);
        if (users.size() > 0) {
            User user = users.get(0);
            String whereBets = String.format("WHERE `fk_users`='%d'", userId);
            req.setAttribute("userId", userId);
            req.setAttribute("userBets", dao.bet.getAll(whereBets));
            req.setAttribute("userLogin", user.getLogin());
            req.setAttribute("races", dao.race.getAll());
            req.setAttribute("events", dao.event.getAll());
            return Action.EDITBETS;
        }
        return Action.EDITUSERS;
    }
}
