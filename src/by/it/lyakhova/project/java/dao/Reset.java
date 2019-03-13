package by.it.lyakhova.project.java.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    public static void main(String[] args) {
        resetSchema();
        createTables();
        fillTables();
    }

    private static void resetSchema() {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement();) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS lyakhova ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS lyakhova DEFAULT CHARACTER SET utf8 ;");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTables() {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement();) {

            statement.executeUpdate("INSERT INTO roles (id, role, description) VALUES (DEFAULT, 'administrator', 'all rights');");
            statement.executeUpdate("INSERT INTO roles (id, role, description) VALUES (DEFAULT, 'editor', 'edit information');");
            statement.executeUpdate("INSERT INTO roles (id, role, description) VALUES (DEFAULT, 'user', 'read, wright');");
            statement.executeUpdate("INSERT INTO roles (id, role, description) VALUES (DEFAULT, 'guess', 'watch');");

            statement.executeUpdate("INSERT INTO users (id, login, password, email, contacts, roles_id) VALUES (DEFAULT, 'petrov', 'petrov', 'petrov@mail.ru', 'petrov@mail.ru', 3);");
            statement.executeUpdate("INSERT INTO users (id, login, password, email, contacts, roles_id) VALUES (DEFAULT, 'sidorov', 'sidorov', 'sidorov@mail.ru', 'sidorov@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO users (id, login, password, email, contacts, roles_id) VALUES (DEFAULT, 'agadjanov', 'agadjanov', 'agadjanov@gmail.com', 'agadjanov@gmail.com', 1);");

            statement.executeUpdate("INSERT INTO tour_type (id, type) VALUES (DEFAULT, 'recreation');");
            statement.executeUpdate("INSERT INTO tour_type (id, type) VALUES (DEFAULT, 'cruise');");
            statement.executeUpdate("INSERT INTO tour_type (id, type) VALUES (DEFAULT, 'shopping');");
            statement.executeUpdate("INSERT INTO tour_type (id, type) VALUES (DEFAULT, 'excursion');");

            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Vietnam', 'Hanoi');");
            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Sri Lanka', 'Kolombo');");
            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Malaysia', 'Kuala Lumpur');");
            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Russia', 'Moscow');");
            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Poland', 'Warszawa');");
            statement.executeUpdate("INSERT INTO place (id, country, town) VALUES (DEFAULT, 'Latvia', 'Riga');");

            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'aircraft');");
            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'bus');");
            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'car');");
            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'train');");
            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'boat');");
            statement.executeUpdate("INSERT INTO transport (id, type) VALUES (DEFAULT, 'cruise');");

            statement.executeUpdate("INSERT INTO housing (id, type) VALUES (DEFAULT, 'hotel');");
            statement.executeUpdate("INSERT INTO housing (id, type) VALUES (DEFAULT, 'apartment');");
            statement.executeUpdate("INSERT INTO housing (id, type) VALUES (DEFAULT, 'house');");

            statement.executeUpdate("INSERT INTO tours (id, name, tour_type_id, place_id, transport_id, housing_id, price, date, duration, hot, discount) VALUES (DEFAULT, 'tour 1', 2, 1, 1, 1, 600, '21.12.2019', 10, NULL, NULL);");
            statement.executeUpdate("INSERT INTO tours (id, name, tour_type_id, place_id, transport_id, housing_id, price, date, duration, hot, discount) VALUES (DEFAULT, 'tour 2', 1, 6, 2, 3, 100, '03.03.2019', 2, NULL, NULL);");
            statement.executeUpdate("INSERT INTO tours (id, name, tour_type_id, place_id, transport_id, housing_id, price, date, duration, hot, discount) VALUES (DEFAULT, 'tour 3', 2, 2, 3, 2, 2000, '01.03.2019', 7, NULL, NULL);");

            statement.executeUpdate("INSERT INTO tours_has_users (id, tours_id, users_id) VALUES (DEFAULT, 1, 1);");
            statement.executeUpdate("INSERT INTO tours_has_users (id, tours_id, users_id) VALUES (DEFAULT, 1, 2);");
            statement.executeUpdate("INSERT INTO tours_has_users (id, tours_id, users_id) VALUES (DEFAULT, 3, 1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createTables() {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS roles (" +
                    "  id INT NOT NULL AUTO_INCREMENT, " +
                    "  role VARCHAR(100) NULL," +
                    "  description VARCHAR(200) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  login VARCHAR(100) NULL," +
                    "  password VARCHAR(100) NULL," +
                    "  email VARCHAR(100) NULL," +
                    "  contacts VARCHAR(150) NULL," +
                    "  roles_id INT NULL," +
                    "  PRIMARY KEY (id)," +
                    "  CONSTRAINT fk_users_roles" +
                    "    FOREIGN KEY (roles_id)" +
                    "    REFERENCES roles (id)" +
                    "    ON DELETE SET NULL" +
                    "    ON UPDATE RESTRICT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tour_type (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  type VARCHAR(100) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS place (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  country VARCHAR(100) NULL," +
                    "  town VARCHAR(100) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS transport (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  type VARCHAR(100) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS housing (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  type VARCHAR(45) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tours (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  name VARCHAR(100) NULL," +
                    "  tour_type_id INT NULL," +
                    "  place_id INT NULL," +
                    "  transport_id INT NULL," +
                    "  housing_id INT NULL," +
                    "  price INT NULL," +
                    "  date VARCHAR(100) NULL," +
                    "  duration INT NULL," +
                    "  hot TINYINT NULL DEFAULT 0," +
                    "  discount INT NULL DEFAULT 0," +
                    "  PRIMARY KEY (id)," +
                    "  CONSTRAINT fk_tours_place1" +
                    "    FOREIGN KEY (place_id)" +
                    "    REFERENCES place (id)" +
                    "    ON DELETE SET NULL" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT fk_tours_transport1" +
                    "    FOREIGN KEY (transport_id)" +
                    "    REFERENCES transport (id)" +
                    "    ON DELETE SET NULL" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT fk_tours_housing1" +
                    "    FOREIGN KEY (housing_id)" +
                    "    REFERENCES housing (id)" +
                    "    ON DELETE SET NULL" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT fk_tours_tour_type1" +
                    "    FOREIGN KEY (tour_type_id)" +
                    "    REFERENCES tour_type (id)" +
                    "    ON DELETE SET NULL" +
                    "    ON UPDATE RESTRICT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tours_has_users (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  tours_id INT NOT NULL," +
                    "  users_id INT NOT NULL," +
                    "  PRIMARY KEY (id, tours_id, users_id)," +
                    "  CONSTRAINT fk_tours_has_users_tours1" +
                    "    FOREIGN KEY (tours_id)" +
                    "    REFERENCES tours (id)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT fk_tours_has_users_users1" +
                    "    FOREIGN KEY (users_id)" +
                    "    REFERENCES users (id)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)");

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
