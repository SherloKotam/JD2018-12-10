package by.it.skosirskiy.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {


     void deleteTables() {
        try (Connection connection =
                         DriverManager.getConnection(
                                 "jdbc:mysql://127.0.0.1:2016/"+
                                         "?useUnicode=true&characterEncoding=UTF-8",
                                 "root",
                                 "");
                 Statement statement = connection.createStatement()
         )  {


//            statement.executeUpdate("DROP TABLE `skosirskiy`.`requests`;");
//            statement.executeUpdate("DROP TABLE `skosirskiy`.`users`;");
//            statement.executeUpdate("DROP TABLE `skosirskiy`.`roles`;");
//            statement.executeUpdate("DROP TABLE `skosirskiy`.`statuses`;");
//            statement.executeUpdate("DROP TABLE `skosirskiy`.`address`;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `skosirskiy`;");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
