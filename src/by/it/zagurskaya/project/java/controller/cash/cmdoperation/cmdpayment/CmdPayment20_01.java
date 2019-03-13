package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

import by.it.zagurskaya.project.java.beans.Currency;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.RateCBDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class CmdPayment20_01 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        LocalDate date = LocalDate.now();
        Timestamp now = new Timestamp(System.currentTimeMillis());

        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);

        if (Form.isPost(req)) {

            long currencyId = Form.getLong(req, "id");
            long currencySum = Form.getLong(req, "sum");
            String specification = Form.getString(req, "specification");

            RateCBDao rateСBDao = new RateCBDao();
            double rateCBPayment = rateСBDao.rateCBToday(now, 933, currencyId);
            double sumRateCurrencyId = rateCBPayment * currencySum;
            HttpSession session = req.getSession(false);
            session.setAttribute("currencyId", currencyId);
            session.setAttribute("currencySum", currencySum);
            session.setAttribute("rateCBPayment", rateCBPayment);
            session.setAttribute("sumRateCurrencyId", sumRateCurrencyId);
            session.setAttribute("specification", specification);

            Action.PAYMENT20_02.setPATH("/cash/operation/payment/");
            return Action.PAYMENT20_02;
        }
        Action.PAYMENT20_01.setPATH("/cash/operation/payment/");
        return Action.PAYMENT20_01;
    }
}
