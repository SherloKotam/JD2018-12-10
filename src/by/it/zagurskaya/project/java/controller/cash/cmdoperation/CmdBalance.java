package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.Kassa;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.KassaDao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class CmdBalance implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);
        KassaDao kassaDao = new KassaDao();

        List<Kassa> balanceList = kassaDao.getAll("WHERE `userId`=" + user.getId() + " AND `dutiesId`=" + duties.get(duties.size()-1).getId());
        req.setAttribute("balanceList", balanceList);

        Action.BALANCE.setPATH("/cash/operation/");
        return Action.BALANCE;
    }
}
