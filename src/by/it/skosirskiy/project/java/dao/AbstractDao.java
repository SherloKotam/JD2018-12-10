package by.it.skosirskiy.project.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            //тут нужно логгирование SQLException(e);
        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }

    long executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return 0;
    }

}
