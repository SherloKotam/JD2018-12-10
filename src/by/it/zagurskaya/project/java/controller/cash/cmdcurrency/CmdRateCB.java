package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.beans.RateCB;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.RateCBDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdRateCB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        List<RateCB> rateCB = new RateCBDao().getAll();
        req.setAttribute("rateCB", rateCB);

        List<Currency> currencyList = new CurrencyDao().getAll();
        req.setAttribute("currencyList", currencyList);

        Action.RATECB.setPATH("/cash/currency/");
        return Action.RATECB;
    }
}
