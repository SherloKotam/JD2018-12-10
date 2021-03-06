package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.beans.Role;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.RoleDao;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            LocalDate date = LocalDate.now();
            String today = Util.getFormattedLocalDateStartDateTime(date);
            DutiesDao dutiesDao = new DutiesDao();
            dutiesDao.OpenDutiesUserToday(user, today).stream().limit(1).forEach(d -> req.setAttribute("duties", d));

            List<Role> roles = new RoleDao().getAll();
            req.setAttribute("roles", roles);

            List<User> users = new UserDao().getAll();
            req.setAttribute("users", users);

            String messageDuties = (dutiesDao.OpenDutiesUserToday(user, today).size() > 0) ? " Открыта смена пользователя" : " Нет открытых смен у пользователя " + user.getLogin();
            req.setAttribute("messageDuties", messageDuties);


            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
