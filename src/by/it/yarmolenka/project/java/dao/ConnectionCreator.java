package by.it.yarmolenka.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    private ConnectionCreator() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            synchronized (ConnectionCreator.class){
                if (connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(CN.URL_DB_ROOT, CN.USER_DB, CN.PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
