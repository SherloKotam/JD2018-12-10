package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.Place;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaceDao extends AbstractDao implements InterfaceDao<Place> {

    @Override
    public Place read(long id) throws SQLException {
        List<Place> place = getAll(" WHERE id = " + id);
        return place.size() == 0 ? null : place.get(0);
    }

    @Override
    public boolean create(Place place) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Place place) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Place place) throws SQLException {
        return false;
    }

    @Override
    public List<Place> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Place> getAll(String where) throws SQLException {
        List<Place> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM place"+ where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getLong("id"));
                place.setCountry(resultSet.getString("country"));
                place.setTown(resultSet.getString("town"));
                result.add(place);
            }
        }
        return result;
    }
}
