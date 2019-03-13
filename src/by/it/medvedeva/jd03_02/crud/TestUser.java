package by.it.medvedeva.jd03_02.crud;

import by.it.medvedeva.jd03_02.beans.User;


import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User user = new User(0, "Ltest", "Ptest", "Etest", 2);
        System.out.println(user);
        if(userCRUD.create(user))
            System.out.println("CREATE: "+user);
        user=userCRUD.read(user);
        if (user!=null)
            System.out.println("READ: "+user);

    }


}