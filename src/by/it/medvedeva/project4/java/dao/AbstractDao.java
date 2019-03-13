package by.it.medvedeva.project4.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    boolean executeUpdate (String  sql) throws SQLException {

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement ()) {
                 return 1 == statement.executeUpdate(sql);
        }


    }


    int executeCreate (String  sql) throws SQLException {

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement ()) {
            int count= statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                     return generatedKeys.getInt(1);
                }
            }
}
            return 0;
        }


}
