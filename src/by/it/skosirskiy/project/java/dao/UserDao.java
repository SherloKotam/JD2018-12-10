package by.it.skosirskiy.project.java.dao;

import by.it.skosirskiy.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDAO<User> {

    @Override
    public List<User> getAll(String WHERE) throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT * FROM `users` " + WHERE + " ;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRoles_id(rs.getInt("roles_id"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> users = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,roles_id)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id()
        );
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }
    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `roles_id` = '%d' WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
