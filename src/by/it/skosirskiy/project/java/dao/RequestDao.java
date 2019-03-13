package by.it.skosirskiy.project.java.dao;

import by.it.skosirskiy.project.java.beans.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDao extends AbstractDao implements InterfaceDAO<Request> {
    @Override
    public Request read(int id) throws SQLException {
        List<Request> requests = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (requests.size() > 0) {
            return requests.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Request request) {
        String sql = String.format(
                "insert INTO requests(type,date_create,date_complete,user_id,status_id,address_id)" +
                        " values('%s','%s','%s',%d,%d,%d);",
                request.getType(), request.getDate_create(), request.getDate_complete(), request.getUser_id(), request.getStatus_id(), request.getAddress_id()
        );
        request.setId(executeUpdate(sql));
        return (request.getId() > 0);
    }

    @Override
    public boolean update(Request request) {
        String sql = String.format(
                "UPDATE `requests` SET `type` = '%s', `date_create` = '%s', `date_complete` = '%s', `user_id` = '%d', `status_id` = '%d', `address_id` = '%d' WHERE `users`.`id` = '%d'",
                request.getType(), request.getDate_create(), request.getDate_complete(), request.getUser_id(), request.getStatus_id(), request.getAddress_id(), request.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Request request) {
        String sql = String.format(
                "DELETE FROM `requests` WHERE `id` = %d;", request.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Request> getAll(String WHERE) throws SQLException {
        List<Request> requests = new ArrayList<>();

        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `requests` " + WHERE + " ;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setType(rs.getString("type"));
                request.setDate_create(rs.getTimestamp("date_create"));
                request.setDate_complete(rs.getTimestamp("date_complete"));
                request.setUser_id(rs.getLong("user_id"));
                request.setStatus_id(rs.getInt("status_id"));
                request.setAddress_id(rs.getInt("address_id"));

                requests.add(request);
            }
        }
        return requests;
    }
}
