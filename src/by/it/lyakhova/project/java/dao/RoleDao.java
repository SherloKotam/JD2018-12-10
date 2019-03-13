package by.it.lyakhova.project.java.dao;

import by.it.lyakhova.project.java.bean.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {


    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll(" WHERE id = " + id);
        return roles.size() == 0 ? null : roles.get(0);
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO roles (role, description) "+
                "VALUES ('%s', '%s',)", role.getRole(), role.getDescription());
        role.setId(executeCreate(sql));
        return role.getId()>0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE roles SET role = '%s', description = '%s' WHERE id = '%d'",
                role.getRole(), role.getDescription(), role.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM roles WHERE id='%d'",
                role.getId());
        return executeUpdate(sql);
    }

    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> result = new ArrayList<>();
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM roles" + where;

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                role.setDescription(resultSet.getString("description"));
                result.add(role);
            }
        }
        return result;
    }
}
