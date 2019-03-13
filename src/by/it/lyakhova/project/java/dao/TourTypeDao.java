package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.TourType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourTypeDao extends AbstractDao implements InterfaceDao<TourType> {

    @Override
    public TourType read(long id) throws SQLException {
        List<TourType> tourType = getAll(" WHERE id = " + id);
        return tourType.size() == 0 ? null : tourType.get(0);
    }

    @Override
    public boolean create(TourType tourType) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TourType tourType) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(TourType tourType) throws SQLException {
        return false;
    }

    @Override
    public List<TourType> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<TourType> getAll(String where) throws SQLException {
        List<TourType> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT*FROM tour_type " + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TourType tourType = new TourType();
                tourType.setId(resultSet.getLong("id"));
                tourType.setType(resultSet.getString("type"));
                result.add(tourType);
            }
        }
        return result;
    }
}
