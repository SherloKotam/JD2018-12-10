package by.it.zagurskaya.project.java.controller.cash.cmdreport;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.controller.Action;
import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Util;
import by.it.zagurskaya.project.java.dao.CurrencyDao;
import by.it.zagurskaya.project.java.dao.DutiesDao;
import by.it.zagurskaya.project.java.dao.SprEntriesDao;
import by.it.zagurskaya.project.java.dao.UserOperationDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CmdEntries implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        LocalDate date = LocalDate.now();
        String today = Util.getFormattedLocalDateStartDateTime(date);
        List<Duties> duties = new DutiesDao().OpenDutiesUserToday(user, today);

        List<UserOperation> userAllOperationList = new UserOperationDao().userAndDutiesOperation(user.getId(), duties.get(duties.size() - 1).getId());
        String allOperationIdsString = userAllOperationList.stream().map(UserOperation::getId).map(Objects::toString).collect(Collectors.joining(","));
        String where = "WHERE `UserOperationId` IN (" + allOperationIdsString + ")";
        List<UserEntry> entriesList = getEntries(where);
        req.setAttribute("entriesList", entriesList);

        List<Currency> currencyList = new CurrencyDao().getAll();
        req.setAttribute("currencyList", currencyList);

        List<SprEntries> sprEntries = new SprEntriesDao().getAll();
        req.setAttribute("sprEntries", sprEntries);

        Action.ENTRIES.setPATH("/cash/report/");
        return Action.ENTRIES;
    }

    public List<UserEntry> getEntries(String where) throws SQLException {
        List<UserEntry> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `accountDebit`,`accountCredit`, `currencyId`, SUM(sum) AS sum,`rate`, sprEntryId FROM `usersEntries` " +
                            where + " GROUP BY `accountDebit`,`accountCredit`");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserEntry userEntry = new UserEntry();
//                userEntry.setId(resultSet.getLong("id"));
//                userEntry.setUserOperationId(resultSet.getLong("UserOperationId"));
                userEntry.setSprEntryId(resultSet.getLong("sprEntryId"));
                userEntry.setCurrencyId(resultSet.getLong("currencyId"));
                userEntry.setAccountDebit(resultSet.getString("accountDebit"));
                userEntry.setAccountCredit(resultSet.getString("accountCredit"));
                userEntry.setSum(resultSet.getDouble("sum"));
//                userEntry.setIsSpending(resultSet.getBoolean("isSpending"));
                userEntry.setRate(resultSet.getDouble("rate"));
                result.add(userEntry);
            }
        }
        return result;
    }
}
