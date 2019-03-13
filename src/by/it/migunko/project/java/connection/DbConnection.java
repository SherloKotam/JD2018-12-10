package by.it.migunko.project.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DbConnection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                }
            }
        }
        return connection;
    }


}
