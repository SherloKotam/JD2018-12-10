package by.it.yarmolenka.project.java.dao;

import by.it.yarmolenka.project.java.beans.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class EventDao extends AbstractDao implements InterfaceDao<Event> {
    @Override
    public Event read(long id) throws SQLException {
        List<Event> events = getAll(String.format("WHERE `id`='%d'", id));
        return events.size() == 0 ? null : events.get(0);
    }

    @Override
    public boolean create(Event event) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `events` (`description`, `odds`, `fk_races`) " +
                "VALUES ('%s', '%f', '%d')", event.getDescription(), event.getOdds(), event.getFk_races());
        event.setId(executeCreate(sql));
        return event.getId() > 0;
    }

    @Override
    public boolean update(Event event) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `events` SET `description`='%s', " +
                        "`odds`='%f', `fk_races`='%d' WHERE `id`='%d'", event.getDescription(),
                event.getOdds(), event.getFk_races(), event.getId());
        return executUpdate(sql);
    }

    @Override
    public boolean delete(Event event) throws SQLException {
        String sql = String.format("DELETE FROM `events` WHERE `id`='%d'", event.getId());
        return executUpdate(sql);
    }

    @Override
    public List<Event> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Event> getAll(String where) throws SQLException {
        List<Event> result = new LinkedList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `events` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getDouble("odds"),
                        resultSet.getLong("fk_races")
                );
                result.add(event);
            }
        }
        return result;
    }
}
