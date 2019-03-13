package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TourDao extends AbstractDao implements InterfaceDao<Tour> {
    @Override
    public Tour read(long id) throws SQLException {
        List<Tour> tours = getAll(" WHERE id = " + id);
        return tours.size() == 0 ? null : tours.get(0);
    }

    @Override
    public boolean create(Tour tour) throws SQLException {
        String sql = String.format("INSERT INTO tours(name, tour_type_id, place_id, transport_id," +
                        "housing_id, price, date, duration, hot, discount) " +
                        "VALUES ('%s', '%d', '%d', '%d', '%d', '%d', '%s', '%d', '%d', '%d')", tour.getName(),
                tour.getTour_type_id(), tour.getPlace_id(), tour.getTransport_id(), tour.getHousing_id(),
                tour.getPrice(), tour.getDate(), tour.getDuration(), tour.getHot(), tour.getDiscount());
        tour.setId(executeCreate(sql));
        return tour.getId()>0;
    }

    @Override
    public boolean update(Tour tour) throws SQLException {
        String sql = String.format(
                "UPDATE tours SET name = '%s', tour_type_id = '%d', place_id = '%d', transport_id = '%d'," +
                        " housing_id = '%d', price = '%d', date = '%s', duration = '%d', hot = '%d'," +
                        " discount = '%d'  WHERE id = '%d'",
                tour.getName(), tour.getTour_type_id(), tour.getPlace_id(), tour.getTransport_id(), tour.getHousing_id(),
                tour.getPrice(), tour.getDate(), tour.getDuration(), tour.getHot(), tour.getDiscount(), tour.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Tour tour) throws SQLException {
        String sql = String.format("DELETE FROM tours WHERE id='%d'",
                tour.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Tour> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Tour> getAll(String where) throws SQLException {
        List<Tour> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM tours " + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getLong("id"));
                tour.setName(resultSet.getString("name"));
                tour.setTour_type_id(resultSet.getLong("tour_type_id"));
                tour.setPlace_id(resultSet.getLong("place_id"));
                tour.setTransport_id(resultSet.getLong("transport_id"));
                tour.setHousing_id(resultSet.getLong("housing_id"));
                tour.setPrice(resultSet.getInt("price"));
                tour.setDate(resultSet.getString("date"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setHot(resultSet.getInt("hot"));
                tour.setDiscount(resultSet.getInt("discount"));
                result.add(tour);
            }
        }
        return result;
    }
}
