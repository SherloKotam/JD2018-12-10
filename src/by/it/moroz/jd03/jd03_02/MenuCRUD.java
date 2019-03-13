package by.it.moroz.jd03.jd03_02;

import by.it.moroz.jd03.jd03_02.beans.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MenuCRUD {

    boolean createMenu(Menu menu) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String create = String.format("INSERT INTO `moroz`.`menu` (`name`, `price`)" +
                            " VALUES ('%s', '%f')", menu.getName(), menu.getPrice());
            int i = statement.executeUpdate(create, Statement.RETURN_GENERATED_KEYS);
            if (i == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    menu.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Menu readMenu(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String read = String.format("SELECT * FROM `menu` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(read);
            if (resultSet.next()) {
                Menu menu = new Menu();
                menu.setId(resultSet.getLong("id"));
                menu.setName(resultSet.getString("name"));
                menu.setPrice(resultSet.getDouble("price"));
                return menu;
            }
        }
        return null;
    }

    boolean updateMenu(Menu menu) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String update = String.format("UPDATE `menu` SET `name`='%s', `price`='%f' " +
                            "WHERE `id`='%d'", menu.getName(), menu.getPrice(), menu.getId());
            return 1==statement.executeUpdate(update);
        }
    }

    boolean deleteMenu(Menu menu) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String delete = String.format("DELETE FROM `menu` WHERE `id`='%d'", menu.getId());
            return 1==statement.executeUpdate(delete);
        }
    }
}
