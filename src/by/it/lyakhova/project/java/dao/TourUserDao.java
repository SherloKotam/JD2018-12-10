package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.TourUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourUserDao extends AbstractDao implements InterfaceDao<TourUser> {

    @Override
    public TourUser read(long id) throws SQLException {
        List<TourUser> users = getAll(" WHERE id = " + id);
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public boolean create(TourUser tourUser) throws SQLException {
        String sql = String.format("INSERT INTO tours_has_users (tours_id, users_id) " +
                "VALUES ('%d', '%d')", tourUser.getTours_id(), tourUser.getUsers_id());
        tourUser.setId(executeCreate(sql));
        return tourUser.getId()>0;
    }

    @Override
    public boolean update(TourUser tourUser) throws SQLException {
        String sql = String.format(
                "UPDATE tours_has_users SET tours_id = '%d', users_id = '%d'",
                tourUser.getTours_id(), tourUser.getUsers_id());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(TourUser tourUser) throws SQLException {
        String sql = String.format("DELETE FROM tours_has_users WHERE id='%d'",
                tourUser.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<TourUser> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<TourUser> getAll(String where) throws SQLException {
        List<TourUser> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM tours_has_users " + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TourUser tourUser = new TourUser();
                tourUser.setId(resultSet.getLong("id"));
                tourUser.setTours_id(resultSet.getLong("tours_id"));
                tourUser.setUsers_id(resultSet.getLong("users_id"));

                result.add(tourUser);
            }
        }
        return result;
    }
}
