package by.it.medvedeva.project4.java.dao;


public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public AdDao ad;
    public HouseadDao housead;

    public void reset(){
        Connect.reset();
    }

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