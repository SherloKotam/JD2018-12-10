package by.it.yarmolenka.project.java.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UniversalDao<Bean> implements InterfaceDao<Bean> {

    private Class<Bean> clazz;
    private String table;
    private Field[] fields;

    public UniversalDao(Class<Bean> clazz) {
        this.clazz = clazz;
        this.table = clazz.getSimpleName().toLowerCase().concat("s");
        this.fields = clazz.getDeclaredFields();
    }

    @Override
    public Bean read(long id) throws SQLException {
        List<Bean> beans = getAll("WHERE `id`=" + id + " LIMIT 0,1");
        return beans.size() > 0 ? beans.get(0) : null;
    }

    @Override
    public boolean create(Bean bean) throws SQLException {
        String names = "";
        String values = "";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                names = names.concat(delimiter + "`" + f.getName().toLowerCase() + "`");
                values = values.concat(delimiter + "'" + f.get(bean) + "'");
                delimiter = ", ";
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO " + table + " (" + names + ") VALUES (" + values + ")";
        int id = executeUpdate(sql, true);
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }

    @Override
    public boolean update(Bean bean) throws SQLException {
        String sql = String.format("UPDATE `%s` SET ", table);
        String del = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                sql = sql.concat(del + "`" + f.getName().toLowerCase() + "` = '" + f.get(bean) + "'");
                del = ", ";
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName().toLowerCase() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }

    @Override
    public boolean delete(Bean bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + table + "` WHERE `id` = '" + fields[0].get(bean) + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }

    @Override
    public List<Bean> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Bean> getAll(String where) throws SQLException {
        List<Bean> beans = new LinkedList<>();
        String sql = String.format("SELECT * FROM `%s` %s", table, where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bean bean = newBean();
                for (int i = 1; i <= fields.length; i++) {
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    try {
                        if (f.getType() == Boolean.class || f.getType() == boolean.class)
                            f.set(bean, resultSet.getBoolean(f.getName()));
                        if (f.getType() == Byte.class || f.getType() == byte.class)
                            f.set(bean, resultSet.getByte(f.getName()));
                        if (f.getType() == Integer.class || f.getType() == int.class)
                            f.set(bean, resultSet.getInt(f.getName()));
                        if (f.getType() == Double.class || f.getType() == double.class)
                            f.set(bean, resultSet.getDouble(f.getName()));
                        if (f.getType() == Float.class || f.getType() == float.class)
                            f.set(bean, resultSet.getFloat(f.getName()));
                        if (f.getType() == Long.class || f.getType() == long.class)
                            f.set(bean, resultSet.getLong(f.getName()));
                        if (f.getType() == Short.class || f.getType() == short.class)
                            f.set(bean, resultSet.getShort(f.getName()));
                        if (f.getType() == String.class)
                            f.set(bean, resultSet.getString(f.getName()));
                        if (f.getType() == Timestamp.class)
                            f.set(bean, resultSet.getTimestamp(f.getName()));
                        if (f.getType() == Date.class)
                            f.set(bean, resultSet.getDate(f.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(bean);
            }
        }
        return beans;
    }

    private Bean newBean() {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int executeUpdate(String sql, boolean returnLastId) throws SQLException {
        int result;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result > 0 && returnLastId) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        }
        return result;
    }
}
