package by.it.lyakhova.project.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            //получим ID, если это требуется извне.
            if (result > 0 && returnLastID) {
                //в MySQL можно так .executeQuery("SELECT LAST_INSERT_ID();");
                //но этот способ надежнее (не зависит от базы данных и безопаснее)
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

    long executeCreate(String sql) throws SQLException {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    return generatedKeys.getLong(1);
                }
            }

        }
        return 0;
    }
}
