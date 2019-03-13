package by.it.medvedeva.jd03_03;

import by.it.medvedeva.jd03_03.beans.User;
import by.it.medvedeva.jd03_03.dao.Dao;


import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();
        User user = new User(0, "Ltest", "Ptest", "Etest", 2);
        if(dao.user.create(user))
            System.out.println("CREATE OK: "+user);
        user.setLogin ("TestUserUpdate");
        if (dao.user.update(user))
            System.out.println("UPDATE OK: "+user);
        user=dao.user.read(user.getId());
        if (user !=null)
            System.out.println("READ OK" +user);

    }

    }