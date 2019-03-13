package by.it.yarmolenka.project.java.dao;

import by.it.yarmolenka.project.java.beans.Bet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class BetDao extends AbstractDao implements InterfaceDao<Bet> {
    @Override
    public Bet read(long id) throws SQLException {
        List<Bet> bets = getAll(String.format("WHERE `id`='%d'", id));
        return bets.size() == 0 ? null : bets.get(0);
    }

    @Override
    public boolean create(Bet bet) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `bets` (`amount`, `payout`, `fk_users`, `fk_events`) " +
                        "VALUES ('%f', '%f', '%d', '%d')", bet.getAmount(), bet.getPayout(), bet.getFk_users(),
                bet.getFk_events());
        bet.setId(executeCreate(sql));
        return bet.getId() > 0;
    }

    @Override
    public boolean update(Bet bet) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `bets` SET `amount`='%f', `payout`='%f', " +
                        "`fk_users`='%d', `fk_events`='%d' WHERE `id`='%d'", bet.getAmount(),
                bet.getPayout(), bet.getFk_users(), bet.getFk_events(), bet.getId());
        return executUpdate(sql);
    }

    @Override
    public boolean delete(Bet bet) throws SQLException {
        String sql = String.format("DELETE FROM `bets` WHERE `id`='%d'", bet.getId());
        return executUpdate(sql);
    }

    @Override
    public List<Bet> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Bet> getAll(String where) throws SQLException {
        List<Bet> result = new LinkedList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `bets` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bet bet = new Bet(
                        resultSet.getLong("id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("payout"),
                        resultSet.getLong("fk_users"),
                        resultSet.getLong("fk_events")
                );
                result.add(bet);
            }
        }
        return result;
    }
}
