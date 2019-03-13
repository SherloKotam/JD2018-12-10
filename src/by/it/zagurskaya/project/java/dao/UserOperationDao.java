package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.UserOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserOperationDao extends AbstractDao implements Dao<UserOperation> {
    @Override
    public boolean create(UserOperation userOperation) throws SQLException {
        String sql = String.format(
                "INSERT INTO `usersOperations`(`timestamp`, `rate`, `sum`, `currencyId`, `userId`,`dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`)" +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                userOperation.getTimestamp(), userOperation.getRate(), userOperation.getSum(), userOperation.getCurrencyId(), userOperation.getUserId(), userOperation.getDutiesId(), userOperation.getOperationId(), userOperation.getSpecification(), userOperation.getCheckingAccount(), userOperation.getFio());
        userOperation.setId(executeCreate(sql));
        return userOperation.getId() > 0;
    }

    @Override
    public UserOperation read(long id) throws SQLException {
        List<UserOperation> userOperations = getAll(" WHERE id=" + id);
        return userOperations.size() == 0 ? null : userOperations.get(0);
    }

    @Override
    public boolean update(UserOperation userOperation) throws SQLException {
        String sql = String.format(
                "UPDATE `usersOperations` SET `timestamp`='%s', `rate`='%s',`sum`='%s' ,`currencyId`='%s' ,`userId`='%s', `dutiesId`='%s', `operationId`='%s',`specification`='%s',`checkingAccount`='%s',`fio`='%s', `id`='%d'  WHERE `id`='%d'",
                userOperation.getTimestamp(), userOperation.getRate(), userOperation.getSum(), userOperation.getCurrencyId(), userOperation.getUserId(), userOperation.getDutiesId(), userOperation.getOperationId(), userOperation.getSpecification(), userOperation.getCheckingAccount(),userOperation.getFio(), userOperation.getId(), userOperation.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(UserOperation userOperation) throws SQLException {
        String sql = String.format(
                "DELETE FROM `usersOperations` WHERE `id`='%s'",
                userOperation.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<UserOperation> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<UserOperation> getAll(String where) throws SQLException {
        List<UserOperation> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `usersOperations` " + where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserOperation userOperation = new UserOperation();
                userOperation.setId(resultSet.getLong("id"));
                userOperation.setTimestamp(resultSet.getTimestamp("timestamp"));
                userOperation.setRate(resultSet.getDouble("rate"));
                userOperation.setSum(resultSet.getDouble("sum"));
                userOperation.setCurrencyId(resultSet.getInt("currencyId"));
                userOperation.setUserId(resultSet.getInt("userId"));
                userOperation.setDutiesId(resultSet.getInt("dutiesId"));
                userOperation.setOperationId(resultSet.getLong("operationId"));
                userOperation.setSpecification(resultSet.getString("specification"));
                userOperation.setCheckingAccount(resultSet.getString("checkingAccount"));
                userOperation.setFio(resultSet.getString("fio"));
                result.add(userOperation);
            }
        }
        return result;
    }

    public List<UserOperation> userAndDutiesOperation(long userId, long dutiesID) throws SQLException {
        String where = String.format(" WHERE `userId`='%d' AND `dutiesId` = '%s' ", userId, dutiesID);
        return getAll(where);
    }
    public List<UserOperation> userAndDutiesAndNumberOperation(long userId, long dutiesID, String number) throws SQLException {
        String where = String.format(" WHERE `userId`='%d' AND `dutiesId` = '%s' AND `operationId` IN ('%s') ", userId, dutiesID, number);
        return getAll(where);
    }
}

