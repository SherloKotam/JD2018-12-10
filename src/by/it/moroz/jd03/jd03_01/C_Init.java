package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void initDB() {
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("%s","DROP SCHEMA IF EXISTS `moroz` ;"));
            statement.executeUpdate(String.format("%s","CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `address` VARCHAR(100) NULL," +
                    "  `name` VARCHAR(100) NULL," +
                    "  `surname` VARCHAR(100) NULL," +
                    "  `numberphone` INT(12) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `moroz`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`menu` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(100) NULL," +
                    "  `price` DOUBLE NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`orders` (" +
                            "  `id` INT NOT NULL AUTO_INCREMENT," +
                            "  `menu_id` INT NOT NULL," +
                            "  `count` INT NULL," +
                            "  `check` DOUBLE NULL," +
                            "  `users_id` INT NOT NULL," +
                            "  PRIMARY KEY (`id`)," +
                            "  INDEX `fk_orders_users1_idx` (`users_id` ASC)," +
                            "  INDEX `fk_orders_Menu1_idx` (`menu_id` ASC)," +
                            "  CONSTRAINT `fk_orders_users1`" +
                            "    FOREIGN KEY (`users_id`)" +
                            "    REFERENCES `moroz`.`users` (`id`)" +
                            "    ON DELETE CASCADE" +
                            "    ON UPDATE CASCADE," +
                            "  CONSTRAINT `fk_orders_Menu1`" +
                            "    FOREIGN KEY (`menu_id`)" +
                            "    REFERENCES `moroz`.`menu` (`id`)" +
                            "    ON DELETE NO ACTION" +
                            "    ON UPDATE NO ACTION)" +
                            "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, " +
                    "`name`, `surname`, `numberphone`, `roles_id`) " +
                    "VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', " +
                    "'Andrei', 'Trizno', 298563456, 2);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', " +
                    "NULL, NULL, 'Maria', 'Borokha', NULL, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', " +
                    "'Vladislau', 'Makarevich', 447568394, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'steak', 29.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'pizza', 13.4);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'spaghetti', 11.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'salad', 9.3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'coffe', 5.0);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 1, 2, 59.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 2, 1, 13.4, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 3, 2, 23.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 4, 1, 9.3, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 5, 1, 5.0, 3);"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
