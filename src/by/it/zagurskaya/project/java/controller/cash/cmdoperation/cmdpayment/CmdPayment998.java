package by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment;

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
import java.util.List;

public class CmdPayment998 implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String today = Util.getFormattedLocalDateStartDateTime(date);
//        "yyyy-MM-dd"
        String todaySQL = Util.getFormattedLocalDateOnlyDate(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);
        KassaDao kassaDao = new KassaDao();


        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAll();
        req.setAttribute("currencies", currencies);

        if (Form.isPost(req)) {

            long sprOperationsId = 998;
            SprOperationsDao sprOperationsDao = new SprOperationsDao();
            List<SprOperations> sprOperations998 = sprOperationsDao.getAll("WHERE `id`=" + sprOperationsId);

            long[] ids = Form.getLongArray(req, "id");
            double[] sums = Form.getDoubleArray(req, "sum");
            String specification = Form.getString(req, "specification");
            String checkingAccount = Form.getString(req, "checkingAccount");
            String fio = Form.getString(req, "fio");


            UserOperationDao userOperationDao = new UserOperationDao();
            RateCBDao rateСBDao = new RateCBDao();
            double rateCBPayment = ids[0]!=933? rateСBDao.rateCBToday(now,ids[0],933):1;
            UserOperation userOperation = new UserOperation(0, now, rateCBPayment, sums[0], ids[0], user.getId(), duties.get(0).getId(), sprOperationsId, specification, checkingAccount,fio);
            userOperationDao.create(userOperation);


            for (int i = 0; i < ids.length; i++) {

                SprEntriesDao sprEntriesDao = new SprEntriesDao();
                List<SprEntries> sprEntries998 = sprEntriesDao.getAll("WHERE `sprOperationsId`=" + sprOperationsId + " AND `currencyId`=" + ids[i]);

                kassaDao.updateKassaInSideOperation(Date.valueOf(todaySQL), duties.get(0).getId(), ids[i], sums[i], sprOperationsId);

                double rateCBPaymentEntry = ids[i]!=933? rateСBDao.rateCBToday(now,ids[i],933):1;

                UserEntryDao userEntryDao = new UserEntryDao();
                UserEntry userEntrys998 = new UserEntry(0, userOperation.getId(), sprEntries998.get(0).getId(), ids[i], sprEntries998.get(0).getAccountDebit(), sprEntries998.get(0).getAccountCredit(), sums[i], sprEntries998.get(0).getIsSpending(),rateCBPaymentEntry);
                userEntryDao.create(userEntrys998);

            }

            Action.CHECK998.setPATH("/cash/operation/check/");
            return Action.CHECK998;
        }

        Action.PAYMENT998.setPATH("/cash/operation/payment/");
        return Action.PAYMENT998;
    }
}
