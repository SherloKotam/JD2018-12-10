package by.it.medvedeva.jd03_02.crud;

import by.it.medvedeva.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`id`,`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getId(), user.getLogin(), user.getEmail(),user.getPassword(), user.getRoles_id()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setRoles_id(id);

                    return true;
                }
            }
            return false;
        }
    }
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `roles_id` = '%d' " +
                        "WHERE id = %d",
                                user.getLogin(), user.getPassword(), user.getEmail(),user.getRoles_id(),user.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

   public User read(User user) throws SQLException {
        User result=null;
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format("SELECT `id`, `login`, `password`, `email`, `roles_id` " +
                    "FROM `users` WHERE id=%d", user.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int roles_id = resultSet.getInt("roles_id");

            };
        }
                return result;
        }

    }





