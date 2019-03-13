package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.beans.RateNB;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.RateNBDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdRateNB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        List<RateNB> rateNB = new RateNBDao().getAll();
        req.setAttribute("rateNB", rateNB);

        List<Currency> currencyList = new CurrencyDao().getAll();
        req.setAttribute("currencyList", currencyList);

        Action.RATENB.setPATH("/cash/currency/");
        return Action.RATENB;
    }
}
