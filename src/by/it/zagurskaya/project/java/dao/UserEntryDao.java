package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.UserEntry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserEntryDao extends AbstractDao implements Dao<UserEntry> {
    @Override
    public boolean create(UserEntry userEntry) throws SQLException {
        String sql = String.format(
                "INSERT INTO `usersEntries`(`userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`)" +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",
                userEntry.getUserOperationId(), userEntry.getSprEntryId(), userEntry.getCurrencyId(), userEntry.getAccountDebit(), userEntry.getAccountCredit(), userEntry.getSum(), userEntry.getIsSpending() ? 1 : 0, userEntry.getRate());
        userEntry.setId(executeCreate(sql));
        return userEntry.getId() > 0;
    }

    @Override
    public UserEntry read(long id) throws SQLException {
        List<UserEntry> userEntry = getAll(" WHERE id=" + id);
        return userEntry.size() == 0 ? null : userEntry.get(0);
    }

    @Override
    public boolean update(UserEntry userEntry) throws SQLException {
        String sql = String.format(
                "UPDATE `usersEntries` SET `userOperationId`='%s', `sprEntryId`='%s',`currencyId`='%s' ,`accountDebit`='%s', `accountCredit`='%s',`sum`='%s',`isSpending`='%s', `rate`='%s',`id`='%d'  WHERE `id`='%d'",
                userEntry.getUserOperationId(), userEntry.getSprEntryId(), userEntry.getCurrencyId(), userEntry.getAccountDebit(), userEntry.getAccountCredit(), userEntry.getSum(), userEntry.getIsSpending() ? 1 : 0, userEntry.getRate(), userEntry.getId(), userEntry.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(UserEntry userEntry) throws SQLException {
        String sql = String.format(
                "DELETE FROM `usersEntries` WHERE `id`='%d'",
                userEntry.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<UserEntry> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<UserEntry> getAll(String where) throws SQLException {
        List<UserEntry> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `usersEntries` " + where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserEntry userEntry = new UserEntry();
                userEntry.setId(resultSet.getLong("id"));
                userEntry.setUserOperationId(resultSet.getLong("UserOperationId"));
                userEntry.setSprEntryId(resultSet.getLong("sprEntryId"));
                userEntry.setCurrencyId(resultSet.getLong("currencyId"));
                userEntry.setAccountDebit(resultSet.getString("accountDebit"));
                userEntry.setAccountCredit(resultSet.getString("accountCredit"));
                userEntry.setSum(resultSet.getDouble("sum"));
                userEntry.setIsSpending(resultSet.getBoolean("isSpending"));
                userEntry.setRate(resultSet.getDouble("rate"));
                result.add(userEntry);
            }
        }
        return result;
    }


}
