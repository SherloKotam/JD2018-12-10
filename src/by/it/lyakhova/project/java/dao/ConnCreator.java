package by.it.lyakhova.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnCreator {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }


    private static volatile Connection connection;

    private ConnCreator(){}

    public static Connection getConnection() throws SQLException {
        if (connection==null || connection.isClosed()){
            synchronized (ConnCreator.class){
                if (connection==null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

}

