package by.it.moroz.jd03.project.java.dao;

import by.it.moroz.jd03.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE `id`='" + id+"'");
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public boolean create(User user) throws SQLException {
            String sql = String.format(
                    "INSERT INTO `moroz`.`users`(`login`, `password`, `email`, `address`, `name`, `surname`, " +
                            "`numberphone`, `roles_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s','%d','%d')",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getAddress(),
                    user.getName(), user.getSurname(),user.getNumberphone(), user.getRoles_id());
            user.setId(executeCreate(sql));
        return user.getId()>0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `moroz`.`users` " +
                        "SET `login`='%s',`password`='%s',`email`='%s',`address`='%s',`name`='%s'," +
                        "`surname`='%s',`numberphone`='%d',`roles_id`='%d' " +
                        "WHERE `id`='%d'",
                user.getLogin(), user.getPassword(), user.getEmail(),user.getAddress(),
                user.getName(),user.getSurname(),user.getNumberphone(),user.getRoles_id(),
                user.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `moroz`.`users` WHERE `id`='%d'",
                user.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String WHERE) throws SQLException {
        List<User> result = new ArrayList<>();
            String sql = String.format(
                    "SELECT * FROM `moroz`.`users` " + WHERE,
                    WHERE);
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setNumberphone(resultSet.getInt("numberphone"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                result.add(user);
            }
        }
        return result;
    }
}
