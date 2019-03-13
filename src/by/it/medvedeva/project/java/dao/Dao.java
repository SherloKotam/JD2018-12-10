package by.it.medvedeva.project.java.dao;


import by.it.medvedeva.project.java.dao.AdDao;
import by.it.medvedeva.project.java.dao.HouseadDao;
import by.it.medvedeva.project.java.dao.RoleDao;
import by.it.medvedeva.project.java.dao.UserDao;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public AdDao ad;
    public HouseadDao housead;

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        ad=new AdDao();
        housead = new HouseadDao();

    }
    public static Dao getDao() {
        if (dao==null){
            synchronized (Dao.class){
                if (dao==null)
                    dao=new Dao();
            }
        }

    return dao;
    }


}