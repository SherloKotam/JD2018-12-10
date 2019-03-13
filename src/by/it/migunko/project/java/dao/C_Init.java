package by.it.migunko.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

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
            Statement statement = connection.createStatement();
            ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `migunko`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `migunko` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `migunko`.`roles` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `migunko`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `migunko`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `migunko`.`tours` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Description` VARCHAR(100) NULL,\n" +
                    "  `TypeOfTravel` VARCHAR(45) NULL,\n" +
                    "  `Destination` VARCHAR(45) NULL,\n" +
                    "  `Hotel` VARCHAR(45) NULL,\n" +
                    "  `CountOfNights` INT NULL,\n" +
                    "  `Price` DOUBLE NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_tours_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_tours_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `migunko`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Agent');");
            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Buyer');");
            statement.executeUpdate("INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'afasf', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'tatiana', 'afdasfafasf', 'tanya@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'evgeniya', 'afetrs', 'zhenya@gmail.com', 3);");
            statement.executeUpdate("INSERT INTO `migunko`.`tours` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `CountOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'bus tour for 3 days', 'excursion', 'Saint-Petersburg', 'Station Hotel', 2, 300.0, 3);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
