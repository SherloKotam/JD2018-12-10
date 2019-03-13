package by.it.migunko.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    static final String dbUrl = "jdbc:mysql://127.0.0.1:2016/";
    static final String dbUser = "root";
    static final String dbPassword = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement()
            ) {

            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`tours` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`roles` ;");
            statement.executeUpdate("DROP DATABASE IF EXISTS `migunko`;");
			
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
