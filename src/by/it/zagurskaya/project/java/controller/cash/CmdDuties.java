package by.it.zagurskaya.project.java.controller.cash;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.Kassa;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.KassaDao;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CmdDuties implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        DutiesDao dutiesDao = new DutiesDao();

        if (Form.isPost(req)) {
            if (req.getParameter("open") != null) {
//                новая запись в duties
                Timestamp now = new Timestamp(System.currentTimeMillis());
                Duties duties = new Duties(0, user.getId(), now, dutiesDao.NumberDutiesToday(user, today), false);
                dutiesDao.create(duties);
//                новая запись в kassa
                CurrencyDao currencyDao = new CurrencyDao();
                KassaDao kassaDao = new KassaDao();

                for (Currency c : currencyDao.getAll()) {
                    kassaDao.create(new Kassa(0, c.getId(), 0, 0, 0, 0, 0, user.getId(), java.sql.Date.valueOf(date), duties.getId()));
                }

            } else if (req.getParameter("close") != null) {
                List<Duties> openDuties = dutiesDao.OpenDutiesUserToday(user, today);
                long id = openDuties.get(openDuties.size() - 1).getId();
                long userId = openDuties.get(openDuties.size() - 1).getUserId();
                Timestamp timestamp = openDuties.get(openDuties.size() - 1).getTimestamp();
                int number = openDuties.get(openDuties.size() - 1).getNumber();
                Duties closeDuties = new Duties(id, userId, timestamp, number, true);
                dutiesDao.update(closeDuties);
            }
        }
        List<User> users = new UserDao().getAll();
        req.setAttribute("users", users);

        dutiesDao.OpenDutiesUserToday(user, today).stream().limit(1).forEach(d -> req.setAttribute("duties", d));
//        List<Duties> openDuties = OpenDutiesUserToday(user, today);
//        if (openDuties.size() > 0) {
//            req.setAttribute("duties", openDuties.get(0));
//        }

        String messageDuties = (dutiesDao.OpenDutiesUserToday(user, today).size() > 0) ? " Открыта смена пользователя" : " Нет открытых смен у пользователя " + user.getLogin();
        req.setAttribute("messageDuties", messageDuties);

        Action.DUTIES.setPATH("/cash/");
        return Action.DUTIES;
    }
}
