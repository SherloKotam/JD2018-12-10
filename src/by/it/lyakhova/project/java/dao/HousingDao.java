package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.Housing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HousingDao extends AbstractDao implements InterfaceDao<Housing> {
    @Override
    public Housing read(long id) throws SQLException {
        List<Housing> housing = getAll(" WHERE id = " + id);
        return housing.size() == 0 ? null : housing.get(0);
    }

    @Override
    public boolean create(Housing housing) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Housing housing) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Housing housing) throws SQLException {
        return false;
    }

    @Override
    public List<Housing> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Housing> getAll(String where) throws SQLException {

        List<Housing> result = new ArrayList<>();

        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM housing"+ where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Housing housing = new Housing();
                housing.setId(resultSet.getLong("id"));
                housing.setType(resultSet.getString("type"));
                result.add(housing);
            }
        }
        return result;
    }
}
