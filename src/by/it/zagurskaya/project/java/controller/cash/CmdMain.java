package by.it.zagurskaya.project.java.controller.cash;

import javax.servlet.http.HttpServletRequest;

import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.UserDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class CmdMain implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        DutiesDao dutiesDao = new DutiesDao();

        if (user != null) {
            List<User> users = new UserDao().getAll();
            req.setAttribute("users", users);

            dutiesDao.OpenDutiesUserToday(user, today).stream().limit(1).forEach(d -> req.setAttribute("duties", d));

            String messageDuties = (dutiesDao.OpenDutiesUserToday(user, today).size() > 0) ? " Открыта смена пользователя " + user.getLogin() : " Нет открытых смен у пользователя " + user.getLogin()+". \n Внимание!!!! Перед началом работы необходимо открыть смену!";
            req.setAttribute("messageDuties", messageDuties);
        }
        Action.MAIN.setPATH("/cash/");
        return Action.MAIN;
    }
}
