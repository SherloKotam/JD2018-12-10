package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.RateCB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateCBDao extends AbstractDao implements Dao<RateCB> {
    @Override
    public boolean create(RateCB rateCB) throws SQLException {
        String sql = String.format(
                "INSERT INTO `rateCB`(`coming`, `spending`, `timestamp`, `sum`,`isBack`) VALUES ('%s','%s','%s','%s','%s')",
                rateCB.getComing(), rateCB.getSpending(), rateCB.getTimestamp(), rateCB.getSum(), rateCB.getIsBack()? 1 : 0);
//        System.out.println(sql);
           rateCB.setId(executeCreate(sql));
        return rateCB.getId() > 0;
    }

    @Override
    public RateCB read(long id) throws SQLException {
        List<RateCB> rateCB = getAll(" WHERE id=" + id);
        return rateCB.size() == 0 ? null : rateCB.get(0);
    }

    @Override
    public boolean update(RateCB rateCB) throws SQLException {
          String sql = String.format(
                  "UPDATE `rateCB` SET `coming`='%s', `spending`='%s',`timestamp`='%s' ,`sum`='%s',`isBack`='%s'  WHERE `id`='%d'",
                  rateCB.getComing(), rateCB.getSpending(), rateCB.getTimestamp(), rateCB.getSum() , rateCB.getIsBack()? 1 : 0, rateCB.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(RateCB rateCB) throws SQLException {
        String sql = String.format(
                "DELETE FROM `rateCB` WHERE `id`='%s'",
                rateCB.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<RateCB> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<RateCB> getAll(String where) throws SQLException {
        List<RateCB> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `rateCB` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                RateCB rateCB = new RateCB();
                rateCB.setId(resultSet.getLong("id"));
                rateCB.setComing(resultSet.getLong("coming"));
                rateCB.setSpending(resultSet.getLong("spending"));
                rateCB.setTimestamp(resultSet.getTimestamp("timestamp"));
                rateCB.setSum(resultSet.getDouble("sum"));
                rateCB.setIsBack(resultSet.getBoolean("isBack"));
                result.add(rateCB);
            }
        }
        return result;
    }
    public double rateCBToday(Timestamp timestamp, long coming, long spending) throws SQLException {
        List<RateCB> rateCB = getAll(" WHERE `timestamp`<='" + timestamp + "' AND `coming`="+coming+" AND `spending`="+spending);
        return rateCB.get(rateCB.size()-1).getSum();
    }

    public List<RateCB> rateCBBuyToday(Timestamp timestamp) throws SQLException {
        List<RateCB> rateCB = getAll(" WHERE `timestamp`<='" + timestamp + "' AND `spending`=933");
        return rateCB;
    }

    public List<RateCB> rateCBSaleToday(Timestamp timestamp) throws SQLException {
        List<RateCB> rateCB = getAll(" WHERE `timestamp`<='" + timestamp + "' AND `coming`=933");
        return rateCB;
    }
}
