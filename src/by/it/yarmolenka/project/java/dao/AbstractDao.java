package by.it.yarmolenka.project.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AbstractDao {

    boolean executUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            return statement.executeUpdate(sql) == 1;
        }
    }

    long executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                    return generatedKeys.getLong(1);
            }
        }
        return -1;
    }
}
