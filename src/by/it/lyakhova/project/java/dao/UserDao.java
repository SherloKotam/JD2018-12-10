package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll(" WHERE id = " + id);
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO users (login, password, email, contacts, roles_id) " +
                "VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(),
                user.getContacts(), user.getRoles_id());
        user.setId(executeCreate(sql));
        return user.getId()>0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE users SET login = '%s', password = '%s', email = '%s'," +
                        " contacts = '%s', roles_id = '%d' WHERE id = '%d'",
                user.getLogin(), user.getPassword(), user.getEmail(),
                user.getContacts(), user.getRoles_id(), user.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM users WHERE id='%d'",
                user.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT*FROM users " + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setContacts(resultSet.getString("contacts"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                result.add(user);
            }
        }
        return result;
    }
}
