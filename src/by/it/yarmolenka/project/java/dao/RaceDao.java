package by.it.yarmolenka.project.java.dao;

import by.it.yarmolenka.project.java.beans.Race;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class RaceDao extends AbstractDao implements InterfaceDao<Race> {

    @Override
    public Race read(long id) throws SQLException {
        List<Race> races = getAll(String.format("WHERE `id`='%d'", id));
        return races.size() == 0 ? null : races.get(0);
    }

    @Override
    public boolean create(Race race) throws SQLException {
        String sql = String.format("INSERT INTO `races` (`date`, `race_track`, `description`) " +
                "VALUES ('%s', '%s', '%s')", race.getDate(), race.getRace_track(), race.getDescription());
        race.setId(executeCreate(sql));
        return race.getId() > 0;
    }

    @Override
    public boolean update(Race race) throws SQLException {
        String sql = String.format("UPDATE `races` SET `date`='%s', `race_track`='%s', " +
                        "`description`='%s' WHERE `id`='%d'", race.getDate(), race.getRace_track(),
                race.getDescription(), race.getId());
        return executUpdate(sql);
    }

    @Override
    public boolean delete(Race race) throws SQLException {
        String sql = String.format("DELETE FROM `races` WHERE `id`='%d'", race.getId());
        return executUpdate(sql);
    }

    @Override
    public List<Race> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Race> getAll(String where) throws SQLException {
        List<Race> result = new LinkedList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `races` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Race race = new Race(
                        resultSet.getLong("id"),
                        resultSet.getTimestamp("date"),
                        resultSet.getString("race_track"),
                        resultSet.getString("description")
                );
                result.add(race);
            }
        }
        return result;
    }
}
