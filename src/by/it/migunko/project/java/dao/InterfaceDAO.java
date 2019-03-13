package by.it.migunko.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<Bean>{

    Bean read(long id) throws SQLException;
    boolean create(Bean been) throws SQLException;
    boolean update(Bean been) throws SQLException;
    boolean delete(Bean been) throws SQLException;
    List<Bean> getAll(String where) throws SQLException;
}
