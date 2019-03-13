package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.Transport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransportDao extends AbstractDao implements InterfaceDao<Transport> {
    @Override
    public Transport read(long id) throws SQLException {
        List<Transport> transport = getAll(" WHERE id = " + id);
        return transport.size() == 0 ? null : transport.get(0);
    }

    @Override
    public boolean create(Transport transport) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Transport transport) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Transport transport) throws SQLException {
        return false;
    }

    @Override
    public List<Transport> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Transport> getAll(String where) throws SQLException {

        List<Transport> result = new ArrayList<>();

        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM transport" + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("id"));
                transport.setType(resultSet.getString("type"));
                result.add(transport);
            }
        }
        return result;
    }
}
