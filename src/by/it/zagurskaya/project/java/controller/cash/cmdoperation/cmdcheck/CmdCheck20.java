package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdcheck;


import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.UserEntryDao;
import by.it.zagurskaya.project.java.dao.UserOperationDao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class CmdCheck20 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);

        List<UserOperation> userAllOperationList = new UserOperationDao().userAndDutiesOperation(user.getId(), duties.get(duties.size() - 1).getId());
        UserOperation userLastOperation = userAllOperationList.get(userAllOperationList.size() - 1);
        req.setAttribute("userOperation", userLastOperation);

        List<UserEntry> userEntryLastOperationList = new UserEntryDao().getAll( "WHERE `UserOperationId`=" +userLastOperation.getId());
        req.setAttribute("userEntriesList", userEntryLastOperationList);

        List<Currency> currencyList = new CurrencyDao().getAll();
        req.setAttribute("currencyList", currencyList);

        Action.CHECK20.setPATH("/cash/operation/check/");
        return Action.CHECK20;
    }
}
