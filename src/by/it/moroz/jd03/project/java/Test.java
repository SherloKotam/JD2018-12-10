package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Menu;
import by.it.moroz.jd03.project.java.beans.User;
import by.it.moroz.jd03.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException {
//        String email = "black.panther.92.hu@gmail.com";
//        if(email.matches("[a-zA-Z0-9._-]{5,}@[a-zA-Z-]{2,}.[a-z]{2,}"))
//            System.out.println(email);
//        else
//            System.out.println("error");

//        List<Menu> menuRest = DAO.getDao().menu.getAll();
//        System.out.println(menuRest);

        DAO dao = DAO.getDao();
        User user = dao.user.read(1);
        System.out.println(Util.getHash(user));
        System.out.println(Util.getHash(user));
    }

}
