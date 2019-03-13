package by.it.lyakhova.project.java.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyUniversalDao<TypeBean> extends AbstractDao implements InterfaceDao<TypeBean> {

    private Class<TypeBean> aClass;
    private String sqlTable;
    private Field[] fields;
    //private static volatile MyUniversalDao MyDao;

    public MyUniversalDao(Class<TypeBean> bean, String sqlTable){
        this.aClass = bean;
        this.sqlTable = sqlTable;
        this.fields = bean.getDeclaredFields(); //all columns names
    }

    /*public static MyUniversalDao getMyUniversalDao(Class<TypeBean> bean, String sqlTable){
        if (MyDao==null){
            synchronized (MyUniversalDao.class){
                if (MyDao==null){
                    MyDao = new MyUniversalDao(bean, sqlTable);
                }
            }
        }
        return MyDao;
    }*/


    @Override
    public TypeBean read(long id) throws SQLException {
        List<TypeBean> beans = getAll(" WHERE id = " + id);
        return beans.size() == 0 ? null : beans.get(0);
    }

    @Override
    public boolean create(TypeBean typeBean) throws SQLException {
        StringBuilder sql = new StringBuilder();
        String del = "";
        sql.append("INSERT INTO ").append(sqlTable).append(" (");

        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sql.append(del).append(fields[i].getName());
            del = ", ";
        }
        del = "";
        sql.append(") VALUES (");
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                sql.append(del).append("\'").append(fields[i].get(typeBean)).append("\'");
                del = ", ";
            }
            sql.append(")");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        long id = executeCreate(sql.toString());
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(typeBean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return id>0;
    }

    @Override
    public boolean update(TypeBean typeBean) throws SQLException {
        StringBuilder sql = new StringBuilder();
        String del = "";
        sql.append("UPDATE ").append(sqlTable).append(" SET ");
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                sql.append(del).append(fields[i].getName()).append(" = ").append("\'").append(fields[i].get(typeBean)).append("\'");
                del = ", ";
            }
            fields[0].setAccessible(true);
            sql.append(" WHERE id = ").append(fields[0].get(typeBean));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return executeUpdate(sql.toString());
    }

    @Override
    public boolean delete(TypeBean typeBean) throws SQLException {
        String sql = null;
        try {
            fields[0].setAccessible(true);
            sql = String.format("DELETE FROM %s WHERE id ='%s'", sqlTable, fields[0].get(typeBean));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return executeUpdate(sql);
    }

    @Override
    public List<TypeBean> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<TypeBean> getAll(String where) throws SQLException {

        List<TypeBean> result = new ArrayList<>();

        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM %s %s ;", sqlTable, where);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                try {
                    Object bean = aClass.newInstance();

                    for (Field field : fields) {

                        field.setAccessible(true);

                        if (field.getType() == int.class || field.getType() == Integer.class)
                            field.set(bean, resultSet.getInt(field.getName()));
                        if (field.getType() == long.class || field.getType() == Long.class)
                            field.set(bean, resultSet.getLong(field.getName()));
                        if (field.getType() == Boolean.class || field.getType() == boolean.class)
                            field.set(bean, resultSet.getBoolean(field.getName()));
                        if (field.getType() == Byte.class || field.getType() == byte.class)
                            field.set(bean, resultSet.getByte(field.getName()));
                        if (field.getType() == Double.class || field.getType() == double.class)
                            field.set(bean, resultSet.getDouble(field.getName()));
                        if (field.getType() == Float.class || field.getType() == float.class)
                            field.set(bean, resultSet.getFloat(field.getName()));
                        if (field.getType() == Short.class || field.getType() == short.class)
                            field.set(bean, resultSet.getShort(field.getName()));
                        if (field.getType() == String.class)
                            field.set(bean, resultSet.getString(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(bean, resultSet.getDate(field.getName()));
                    }
                    //noinspection unchecked
                    result.add((TypeBean) bean);

                }catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        return result;
        }

}

