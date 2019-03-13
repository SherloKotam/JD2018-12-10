package by.it.moroz.jd03.project.java.dao;

import by.it.moroz.jd03.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {


    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE `id`=" + id);
        return roles.size() == 0 ? null : roles.get(0);

    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `moroz`.`roles`(`role`) VALUES ('%s')",
                role.getRole());
        role.setId(executeCreate(sql));
        return role.getId()>0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `moroz`.`roles` SET `role`='%s' WHERE `id`='%d'",
                role.getRole(), role.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `moroz`.`roles` WHERE `id`='%d'", role.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String WHERE) throws SQLException {
        List<Role> result = new ArrayList<>();
            String sql = "SELECT * FROM `moroz`.`roles` "+WHERE;
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                result.add(role);
            }
        }
        return result;
    }
}
