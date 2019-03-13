package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class CmdUseroperations implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);

        List<UserOperation> userAllOperationList = new UserOperationDao().userAndDutiesOperation(user.getId(), duties.get(duties.size() - 1).getId());
        req.setAttribute("userAllOperationList", userAllOperationList);

        List<SprOperations> sprOperationsList = new SprOperationsDao().getAll();
        req.setAttribute("sprOperationsList", sprOperationsList);

        List<Currency> currencyList = new CurrencyDao().getAll();
        req.setAttribute("currencyList", currencyList);


        Action.USEROPERATIONS.setPATH("/cash/operation/");
        return Action.USEROPERATIONS;
    }
}
