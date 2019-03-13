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

public class CmdPayment1000 implements Cmd {
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

            long sprOperationsId = 1000;
            SprOperationsDao sprOperationsDao = new SprOperationsDao();
            List<SprOperations> sprOperations1000 = sprOperationsDao.getAll("WHERE `id`=" + sprOperationsId);

            long[] ids = Form.getLongArray(req, "id");
            double[] sums = Form.getDoubleArray(req, "sum");
            String specification = Form.getString(req, "specification");


            UserOperationDao userOperationDao = new UserOperationDao();
            UserOperation userOperation = new UserOperation(0, now, 1, sums[0], ids[0], user.getId(), duties.get(0).getId(), sprOperationsId, specification, null,null);
            userOperationDao.create(userOperation);


            for (int i = 0; i < ids.length; i++) {

                SprEntriesDao sprEntriesDao = new SprEntriesDao();
                List<SprEntries> sprEntries1000 = sprEntriesDao.getAll("WHERE `sprOperationsId`=" + sprOperationsId + " AND `currencyId`=" + ids[i]);

//                Kassa kassa = kassaDao.readByCurrencyIdAndDateAndDutiesNumber(ids[i],  Date.valueOf(todaySQL), duties.get(0).getNumber());
                kassaDao.updateKassaOutSideOperation(Date.valueOf(todaySQL), duties.get(0).getId(), ids[i], sums[i], sprOperationsId);

                RateNBDao rateNBDao = new RateNBDao();
                UserEntryDao userEntryDao = new UserEntryDao();
                UserEntry userEntrys1000 = new UserEntry(0, userOperation.getId(), sprEntries1000.get(0).getId(), ids[i], sprEntries1000.get(0).getAccountDebit(), sprEntries1000.get(0).getAccountCredit(), sums[i], sprEntries1000.get(0).getIsSpending(), rateNBDao.rateNBToday(Date.valueOf(todaySQL), ids[i]));
                userEntryDao.create(userEntrys1000);

            }

            Action.CHECK1000.setPATH("/cash/operation/check/");
            return Action.CHECK1000;
        }
        Action.PAYMENT1000.setPATH("/cash/operation/payment/");
        return Action.PAYMENT1000;
    }
}
