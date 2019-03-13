package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Form;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class CmdPayment10_02 implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession(false);
        Long currencyIdSession = (Long) session.getAttribute("currencyId");
        req.setAttribute("currencyId", currencyIdSession);
        Long currencySumSession = (Long) session.getAttribute("currencySum");
        req.setAttribute("currencySum", currencySumSession);
        Double rateCBPaymentSession = (Double) session.getAttribute("rateCBPayment");
        req.setAttribute("rateCBPayment", rateCBPaymentSession);
        Double sumRateCurrencyIdSession = (Double) session.getAttribute("sumRateCurrencyId");
        req.setAttribute("sumRateCurrencyId", Math.round(sumRateCurrencyIdSession * 100.0) / 100.0);
        String specificationSession = (String) session.getAttribute("specification");
        req.setAttribute("specification", specificationSession);

        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);

        if (Form.isPost(req)) {

            User user = Util.findUser(req);
            LocalDate date = LocalDate.now();
            Timestamp now = new Timestamp(System.currentTimeMillis());
            String today = Util.getFormattedLocalDateStartDateTime(date);
//        "yyyy-MM-dd"
            String todaySQL = Util.getFormattedLocalDateOnlyDate(date);
            List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);
            KassaDao kassaDao = new KassaDao();

            long sprOperationsId = 10;

            long[] ids = Form.getLongArray(req, "id");
            double[] sums = Form.getDoubleArray(req, "sum");
            String specification = specificationSession;


            UserOperationDao userOperationDao = new UserOperationDao();
            UserOperation userOperation = new UserOperation(0, now, rateCBPaymentSession, sums[0], ids[0], user.getId(), duties.get(0).getId(), sprOperationsId, specification, null,null);
            userOperationDao.create(userOperation);


            for (int i = 0; i < ids.length; i++) {

                SprEntriesDao sprEntriesDao = new SprEntriesDao();
                List<SprEntries> sprEntries10= sprEntriesDao.getAll("WHERE `sprOperationsId`=" + sprOperationsId + " AND `currencyId`=" + ids[i]);

                kassaDao.updateKassaInSideOperation(Date.valueOf(todaySQL), duties.get(0).getId(), ids[i], sums[i], sprOperationsId);

                double rateCBPaymentEntry = ids[i]!=933? rateCBPaymentSession:1;

                UserEntryDao userEntryDao = new UserEntryDao();
                UserEntry userEntrys = new UserEntry(0, userOperation.getId(), sprEntries10.get(0).getId(), ids[i], sprEntries10.get(0).getAccountDebit(), sprEntries10.get(0).getAccountCredit(), sums[i], sprEntries10.get(0).getIsSpending(),rateCBPaymentEntry);
                userEntryDao.create(userEntrys);

            }

            Action.CHECK10.setPATH("/cash/operation/check/");
            return Action.CHECK10;
        }
        Action.PAYMENT10_02.setPATH("/cash/operation/payment/");
        return Action.PAYMENT10_02;
    }
}
