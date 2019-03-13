package by.it.yarmolenka.project.java.dao;

import by.it.yarmolenka.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll(String.format("WHERE `id`='%d'", id));
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `users` (`login`, `email`, `password`, `cashier`, " +
                        "`fk_roles`) VALUES ('%s', '%s', '%s', '%f', '%d')", user.getLogin(),
                user.getEmail(), user.getPassword(), user.getCashier(), user.getFk_roles());
        user.setId(executeCreate(sql));
        return user.getId() > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `users` SET `login`='%s', `email`='%s', " +
                        "`password`='%s', `cashier`='%f', `fk_roles`='%d' WHERE `id`='%d'", user.getLogin(),
                user.getEmail(), user.getPassword(), user.getCashier(), user.getFk_roles(), user.getId());
        return executUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `id`='%d'", user.getId());
        return executUpdate(sql);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> result = new LinkedList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `users` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getDouble("cashier"),
                        resultSet.getLong("fk_roles")
                );
                result.add(user);
            }
        }
        return result;
    }
}
