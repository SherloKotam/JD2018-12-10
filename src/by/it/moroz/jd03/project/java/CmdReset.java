package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CmdReset implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        if (Form.isPost(req)) {
            resetDB();
            createDB();
            addRoles();
            addMenu();
            addUsers();
            addOrder();
            return Action.INDEX;
        }
        return Action.RESET;
    }

    private void resetDB(){
        try (Connection connection = ConnCreator.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","DROP SCHEMA IF EXISTS `moroz` ;"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDB() {
        try (Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
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
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMenu() {
        try (Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'Steak', 29.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'Pizza', 13.4);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'Spaghetti', 11.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'Salad', 9.3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'Coffee', 5.0);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRoles() {
        try (Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUsers(){
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
             statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, " +
                    "`name`, `surname`, `numberphone`, `roles_id`) " +
                    "VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', " +
                    "'Andrei', 'Trizno', 298563456, 2);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', " +
                    "'borokhaM@gmail.com', NULL, 'Maria', 'Borokha', NULL, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'Vladik', '321ytrewq', 'supervlad@gmail.com', 'Kedishko, 3-1', " +
                    "'Vladislau', 'Makarevich', 447568394, 3);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addOrder() {
        try (Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
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
