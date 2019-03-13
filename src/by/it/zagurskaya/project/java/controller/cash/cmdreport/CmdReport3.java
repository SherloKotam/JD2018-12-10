package by.it.zagurskaya.project.java.controller.cash.cmdreport;

import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.UserOperationDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class CmdReport3 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);

        String sprOperationsId = "998";

        UserOperationDao userOperationDao = new UserOperationDao();
        List<UserOperation> userOperation998 = userOperationDao.userAndDutiesAndNumberOperation(user.getId(), duties.get(duties.size() - 1).getId(), sprOperationsId);

        req.setAttribute("userOperation998", userOperation998);
        req.setAttribute("now", now);

        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);
        Action.REPORT3.setPATH("/cash/report/");
        return Action.REPORT3;
    }
}
