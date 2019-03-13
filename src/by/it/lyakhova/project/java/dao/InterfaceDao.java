package by.it.lyakhova.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TypeBean> {

    public TypeBean read(long id) throws SQLException;
    public boolean create(TypeBean typeBean) throws SQLException;
    public boolean update(TypeBean typeBean) throws SQLException;
    public boolean delete(TypeBean typeBean) throws SQLException;
    public List<TypeBean> getAll() throws SQLException;
    public List<TypeBean> getAll(String where) throws SQLException;
}
