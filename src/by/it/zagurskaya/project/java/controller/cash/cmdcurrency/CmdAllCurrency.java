package by.it.zagurskaya.project.java.controller.cash.cmdcurrency;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.dao.CurrencyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdAllCurrency implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        List<Currency> currency = new CurrencyDao().getAll();
        req.setAttribute("currency", currency);
        Action.ALLCURRENCY.setPATH("/cash/currency/");
        return Action.ALLCURRENCY;
    }
}
