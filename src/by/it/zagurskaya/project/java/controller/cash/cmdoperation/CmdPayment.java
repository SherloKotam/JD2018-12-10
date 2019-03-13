package by.it.zagurskaya.project.java.controller.cash.cmdoperation;

import by.it.zagurskaya.project.java.beans.SprOperations;
import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.controller.*;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.SprOperationsDao;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CmdPayment implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);

        List<User> users = new UserDao().getAll();
        req.setAttribute("users", users);

        DutiesDao dutiesDao = new DutiesDao();
        dutiesDao.OpenDutiesUserToday(user, today).stream().limit(1).forEach(d -> req.setAttribute("duties", d));
        String message = (dutiesDao.OpenDutiesUserToday(user, today).size() == 0) ? " Нет открытых смен у пользователя " + user.getLogin():"";
        req.setAttribute("message", message);

        SprOperationsDao sprOperationsDao = new SprOperationsDao();
        List<SprOperations> sprOperationsAll = sprOperationsDao.getAll();
        req.setAttribute("sprOperationsAll", sprOperationsAll);


        if (Form.isPost(req)) {
            List<SprOperations> selectedOperationFromSprOperationsList = new ArrayList<SprOperations>();
            Long sprOperationsId = Long.parseLong(Form.getString(req, "SprOperationsId"));
            if (sprOperationsId != null) {

                selectedOperationFromSprOperationsList.addAll(sprOperationsDao.getAll(" WHERE id=" + sprOperationsId));
                SprOperations sprOperations = selectedOperationFromSprOperationsList.get(0);
                if (selectedOperationFromSprOperationsList.size() > 0) {
                    req.setAttribute("SprOperations", selectedOperationFromSprOperationsList.get(0));
                }
                switch(sprOperationsId.toString()) {
                    case "10":
                        Action.PAYMENT10_01.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT10_01;
                    case "20":
                        Action.PAYMENT20_01.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT20_01;
                    case "998":
                        Action.PAYMENT998.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT998;
                    case "1000":
                        Action.PAYMENT1000.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT1000;
                    case "1100":
                        Action.PAYMENT1100.setPATH("/cash/operation/payment/");
                        return Action.PAYMENT1100;
                    default : //необязательно
                        Action.PAYMENT.setPATH("/cash/operation/");
                        return Action.PAYMENT;
                }
            }
        }
        Action.PAYMENT.setPATH("/cash/operation/");
        return Action.PAYMENT;
    }
}
