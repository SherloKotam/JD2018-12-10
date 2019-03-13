package by.it.medvedeva.project.java.dao;


import by.it.medvedeva.project.java.dao.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static volatile Connection connection;
    static public Connection getConnection() throws SQLException{
        if (connection ==null || connection.isClosed()){
            synchronized (Connect.class){
                if (connection ==null || connection.isClosed()){
                    connection = DriverManager.getConnection(by.it.medvedeva.project.java.dao.CN.URL, by.it.medvedeva.project.java.dao.CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }
     static void reset() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }



        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `medvedeva` ;");
            statement.executeUpdate(
                    "CREATE SCHEMA IF NOT EXISTS `medvedeva` " +
                            "DEFAULT CHARACTER SET utf8 ;"
            );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `medvedeva`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `medvedeva`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `medvedeva`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `medvedeva`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `medvedeva`.`ads` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `description` VARCHAR(3000) NULL," +
                    "  `address` VARCHAR(555) NULL," +
                    "  `floor` INT NULL," +
                    "  `floors` INT NULL," +
                    "  `rooms` INT NULL," +
                    "  `area` DOUBLE NULL," +
                    "  `price` DOUBLE NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_ads_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `medvedeva`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `medvedeva`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `medvedeva`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `medvedeva`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `medvedeva`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'administrator@mail.ru', 'administrator', 1);");
            statement.executeUpdate("INSERT INTO `medvedeva`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2);");
            statement.executeUpdate("INSERT INTO `medvedeva`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'petrov', 'petrov@mail.ru', 'petrov', 2);");
            statement.executeUpdate("INSERT INTO `medvedeva`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'babochkin', 'babochkin@mail.ru', 'babochkin', 3);");
            statement.executeUpdate("INSERT INTO `medvedeva`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `users_id`) VALUES (DEFAULT, 'Good appartments', 'Minsk Lenina str., 10 app.12', 3, 5, 2, 55, 77777, 3);");
            statement.executeUpdate("INSERT INTO `medvedeva`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `users_id`) VALUES (DEFAULT, 'Маленький домик', 'Minsk Halturina, 14', 1, 1, 2, 44, 55555, 3);");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}


