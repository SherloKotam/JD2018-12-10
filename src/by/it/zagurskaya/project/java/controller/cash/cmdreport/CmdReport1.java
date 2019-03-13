package by.it.zagurskaya.project.java.controller.cash.cmdreport;

import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdReport1 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);
        List<Report1> report1List = new ArrayList<Report1>();

        String sprOperationsId = "10";

        UserOperationDao userOperationDao = new UserOperationDao();
        List<UserOperation> userOperation10 = userOperationDao.userAndDutiesAndNumberOperation(user.getId(), duties.get(duties.size() - 1).getId(), sprOperationsId);


        for (int i = 0; i < userOperation10.size(); i++) {

            List<UserEntry> userEntryList = new UserEntryDao().getAll("WHERE `userOperationId`=" + userOperation10.get(i).getId());

            for (int j = 0; j < userEntryList.size(); j++) {
                if (userEntryList.get(j).getCurrencyId() == 933) {
                    double sum = userEntryList.get(j).getSum();
                    Report1 report1 = new Report1(userOperation10.get(i), sum);
                    report1List.add(report1);
                }
            }
        }
        req.setAttribute("report1List", report1List);
        req.setAttribute("now", now);

        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);

        Action.REPORT1.setPATH("/cash/report/");
        return Action.REPORT1;
    }
}
