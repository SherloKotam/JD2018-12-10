package by.it.migunko.project.java.dao;


import by.it.migunko.project.java.beans.Roles;
import by.it.migunko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RolesDao extends AbstractDao implements InterfaceDAO<Roles> {

    @Override
    public boolean create(Roles roles) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles`(`role`) VALUES ('%s')",
                roles.getRole());
        long id = executeUpdate(sql);
        if (id > 0) {
            roles.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public Roles read(long id) throws SQLException {
        List<Roles> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean update(Roles roles) throws SQLException {
        String sql = String.format( "UPDATE `roles` SET `role`='%s' WHERE id=%d",
                roles.getRole(), roles.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Roles roles) throws SQLException {
        String sql = String.format( "DELETE FROM `roles` WHERE id=%d", roles.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Roles> getAll(String where) throws SQLException {
        List<Roles> roles = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format( "SELECT `id`, `role` FROM `roles` %s", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Roles role = new Roles(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
                roles.add(role);
            }
        }
        return roles;
    }
}
