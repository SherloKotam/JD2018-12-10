package by.it.subach.project.java.dao.dbInit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//    }

    public static void main(String[] args) {

        try(Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                            "?useUnicode=true&characterEncoding=UTF-8",
                            "root",
                            "");
            Statement statement = connection.createStatement()
                ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `subach` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `subach` DEFAULT CHARACTER SET utf8 ;"
             );

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT COMMENT '\t\t'," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT COMMENT '\'," +
                    "  `login` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `role_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_role`" +
                    "    FOREIGN KEY (`role_id`)" +
                    "    REFERENCES `subach`.`roles` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`categories` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `category_name` VARCHAR(45) NULL," +
                    "  `category_description` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`products` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `product_name` VARCHAR(100) NULL," +
                    "  `product_price` DOUBLE NULL," +
                    "  `product_description` VARCHAR(1000) NULL," +
                    "  `categories_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_products_categories1`" +
                    "    FOREIGN KEY (`categories_id`)" +
                    "    REFERENCES `subach`.`categories` (`id`)" +
                    "    ON DELETE CASCADE" +       // no action
                    "    ON UPDATE CASCADE)" +      // no action
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`orders` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `user_id` INT NOT NULL," +
                    "  `product_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_orders_users1`" +
                    "    FOREIGN KEY (`user_id`)" +
                    "    REFERENCES `subach`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +       //no action
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_orders_products1`" +
                    "    FOREIGN KEY (`product_id`)" +
                    "    REFERENCES `subach`.`products` (`id`)" +
                    "    ON DELETE CASCADE" +       //
                    "    ON UPDATE CASCADE)" +      //no action
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`blacklist` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `user_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_blacklist_users1`" +
                    "    FOREIGN KEY (`user_id`)" +
                    "    REFERENCES `subach`.`users` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`checkout` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `checkout_status` TINYINT(1) NULL," +
                    "  `order_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_checkout_orders1`" +
                    "    FOREIGN KEY (`order_id`)" +
                    "    REFERENCES `subach`.`orders` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");

//            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, '');");
            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'admin', 'qwerty', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'VasyaP', '1234', 'vasia@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'PetyaS', 'qqqq', 'petya@tut.by', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'SvetaV', 'aaaa1', 'sveta@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'Alfonso', 'zxcv', 'alfonso@yahoo.com', 3);");
            statement.executeUpdate("INSERT INTO `subach`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'consoles', 'Consoles');");
            statement.executeUpdate("INSERT INTO `subach`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'games', 'Console games');");
            statement.executeUpdate("INSERT INTO `subach`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'accessorise', 'Accessorise for consoles');");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Play Station 5', 499.90, 'Best console fron Sony', 1);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Xbox720', 599.90, 'Console from Microsoft', 1);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Nintendo Woo', 350.50, 'Family console fron Nintendo', 1);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Call of Booty 5', 50.00, 'FPS', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Heroes 3', 15.99, 'Strategy', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Baldurs gate 3 ', 19.99, 'RPG ', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Dualshock 5', 80.00, 'Gamepad for PS5', 3);");
            statement.executeUpdate("INSERT INTO `subach`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 2, 3);");
            statement.executeUpdate("INSERT INTO `subach`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 2, 4);");
            statement.executeUpdate("INSERT INTO `subach`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 3, 5);");



            System.out.println("DataBase RESTORED");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
