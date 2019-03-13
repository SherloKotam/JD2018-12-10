package by.it.yarmolenka.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Bean> {

    Bean read(long id) throws SQLException;

    boolean create(Bean bean) throws SQLException;

    boolean update(Bean bean) throws SQLException;

    boolean delete(Bean bean) throws SQLException;

    List<Bean> getAll() throws SQLException;

    List<Bean> getAll(String where) throws SQLException;
}
