package by.it.medvedeva.jd03_03.dao;

import by.it.medvedeva.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDao extends AbstractDao implements InterfaceDao <User> {



    @Override
    public boolean create(User user) throws SQLException {
                    String sql = String.format("INSERT INTO 'users' ('login', 'email', 'password', roles_id')" +
                    "VALUES ('%s','%s','%s','%d')",
                    user.getLogin(), user.getEmail(),
                    user.getPassword(), user.getFk_roles());

           user.setId(executeCreate(sql));

                   return user.getId()>0;
    }

    @Override
    public boolean update(User user) throws SQLException {
            String sql = String.format(
                    "UPDATE `users` " +
                            "SET `login`='%s',`email`='%s',`password`='%s',`roles_id`='%d' " +
                            "WHERE `id`='%d'",
                    user.getLogin(), user.getEmail(), user.getPassword(), user.getFk_roles(),
                    user.getId());

        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement ()) {
            String sql = String.format(
                    "DELETE FROM 'users' WHERE 'id'='%id'",
                    user.getId());
            return executeUpdate(sql);


        }
    }
    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE id=" +id);
        return users.size() == 0 ? null : users.get(0);

    }
    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> result= new ArrayList<>();
        try (Connection connection=Connect.getConnection();
        Statement statement = connection.createStatement()){
            String sql=String.format(
                    "SELECT * FROM 'users' "+where);
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFk_roles(resultSet.getInt("roles_id"));
                result.add(user);
            }
        }
        return result;
    }
}
