package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.RateNB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateNBDao extends AbstractDao implements Dao<RateNB> {
    @Override
    public boolean create(RateNB rateNB) throws SQLException {
        String sql = String.format(
                "INSERT INTO `rateNB`(`currencyId`, `date`, `sum`) VALUES ('%s','%s','%s')",
                rateNB.getCurrencyId(), rateNB.getDate(), rateNB.getSum());
//        System.out.println(sql);
        rateNB.setId(executeCreate(sql));
        return rateNB.getId() > 0;
    }

    @Override
    public RateNB read(long id) throws SQLException {
        List<RateNB> rateNB = getAll(" WHERE id=" + id);
        return rateNB.size() == 0 ? null : rateNB.get(0);
    }

    @Override
    public boolean update(RateNB rateNB) throws SQLException {
          String sql = String.format(
                  "UPDATE `rateNB` SET `currencyId`='%s', `date`='%s',`sum`='%s' WHERE `id`='%d'",
                  rateNB.getCurrencyId(), rateNB.getDate(), rateNB.getSum(), rateNB.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(RateNB rateNB) throws SQLException {
        String sql = String.format(
                "DELETE FROM `rateNB` WHERE `id`='%s'",
                rateNB.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<RateNB> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<RateNB> getAll(String where) throws SQLException {
        List<RateNB> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `rateNB` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                RateNB rateNB = new RateNB();
                rateNB.setId(resultSet.getLong("id"));
                rateNB.setCurrencyId(resultSet.getLong("currencyId"));
                rateNB.setDate(resultSet.getDate("date"));
                rateNB.setSum(resultSet.getDouble("sum"));
                result.add(rateNB);
            }
        }
        return result;
    }
    public double rateNBToday(Date date, long currencyId) throws SQLException {

        List<RateNB> rateNB = getAll(" WHERE `date`<='" + date + "' AND `currencyId`="+currencyId);
        return rateNB.get(rateNB.size()-1).getSum();
    }

}
