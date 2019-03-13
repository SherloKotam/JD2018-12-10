package by.it.zagurskaya.project.java.dao;

import by.it.zagurskaya.project.java.ConnCreator;
import by.it.zagurskaya.project.java.beans.Duties;
import by.it.zagurskaya.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DutiesDao extends AbstractDao implements Dao<Duties> {
    @Override
    public boolean create(Duties duties) throws SQLException {
        String sql = String.format(
                "INSERT INTO `duties`(`userId`, `timestamp`, `number`, `isClose`) VALUES ('%s','%s','%s','%s')",
                duties.getUserId(), duties.getTimestamp(), duties.getNumber(), duties.getIsClose() ? 1 : 0);
//        System.out.println(sql);
        duties.setId(executeCreate(sql));
        return duties.getId() > 0;
    }

    @Override
    public Duties read(long id) throws SQLException {
        List<Duties> duties = getAll(" WHERE id=" + id);
        return duties.size() == 0 ? null : duties.get(0);
    }

    @Override
    public boolean update(Duties duties) throws SQLException {
          String sql = String.format(
                  "UPDATE `duties` SET `userId`='%s', `timestamp`='%s',`number`='%s' ,`isClose`='%s',`id`='%d'  WHERE `id`='%d'",
                  duties.getUserId(), duties.getTimestamp(), duties.getNumber(), duties.getIsClose() ? 1 : 0, duties.getId(), duties.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Duties duties) throws SQLException {
        String sql = String.format(
                "DELETE FROM `duties` WHERE `id`='%s'",
                duties.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Duties> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Duties> getAll(String where) throws SQLException {
        List<Duties> result = new ArrayList<>();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `duties` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Duties duties = new Duties();
                duties.setId(resultSet.getLong("id"));
                duties.setUserId(resultSet.getLong("userId"));
                duties.setTimestamp(resultSet.getTimestamp("timestamp"));
                duties.setNumber(resultSet.getInt("number"));
                duties.setIsClose(resultSet.getBoolean("isClose"));
                result.add(duties);
            }
        }
        return result;
    }
    public static Integer NumberDutiesToday(User user, String today) throws SQLException {
        DutiesDao dutiesDao = new DutiesDao();

        if (user == null) {
            throw new IllegalArgumentException("пользователь должен быть!!!");
        }


        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`= 1", user.getId(), today);
        List<Duties> closeDutiesList = dutiesDao.getAll(where);

        Integer numberDuties = closeDutiesList.stream().map(Duties::getNumber).max(Integer::compareTo).orElse(0) + 1;
//            if (closeDutiesList.size() != 0) {
//                List<Integer> closeDutiesNumberList = new ArrayList<Integer>();
//                for (Duties duties : closeDutiesList) {
//                    closeDutiesNumberList.add(duties.getNumber());
//                }
//                numberDuties = Integer.parseInt(Collections.max(closeDutiesNumberList).toString()) + 1;
//            } else {
//                numberDuties = 1;
//            }
        return numberDuties;
    }

    public Long IdDutiesToday(User user, String today) throws SQLException {
        DutiesDao dutiesDao = new DutiesDao();

        if (user == null) {
            throw new IllegalArgumentException("пользователь должен быть!!!");
        }


        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`= 1", user.getId(), today);
        List<Duties> closeDutiesList = dutiesDao.getAll(where);

        Long numberDuties = closeDutiesList.stream().map(Duties::getId).max(Long::compareTo).orElseThrow(IllegalArgumentException::new);
        return numberDuties;
    }

    public List<Duties> OpenDutiesUserToday(User user, String today) throws SQLException {
        String where = String.format(" WHERE `userId`='%d' AND `timestamp` >= '%s' AND `isClose`=0", user.getId(), today);
        DutiesDao dutiesDao = new DutiesDao();
        List<Duties> duties = dutiesDao.getAll(where);
        return duties;
    }

}
