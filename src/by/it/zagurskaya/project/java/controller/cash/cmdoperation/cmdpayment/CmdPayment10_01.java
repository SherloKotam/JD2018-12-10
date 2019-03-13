package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.dao.*;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class CmdPayment10_01 implements Cmd {
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
            double rateCBPayment = rateСBDao.rateCBToday(now, currencyId, 933);
            double sumRateCurrencyId = rateCBPayment * currencySum;
            HttpSession session = req.getSession(false);
            session.setAttribute("currencyId", currencyId);
            session.setAttribute("currencySum", currencySum);
            session.setAttribute("rateCBPayment", rateCBPayment);
            session.setAttribute("sumRateCurrencyId", sumRateCurrencyId);
            session.setAttribute("specification", specification);

            Action.PAYMENT10_02.setPATH("/cash/operation/payment/");
            return Action.PAYMENT10_02;
        }
        Action.PAYMENT10_01.setPATH("/cash/operation/payment/");
        return Action.PAYMENT10_01;
    }
}
