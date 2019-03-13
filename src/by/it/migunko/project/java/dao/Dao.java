package by.it.migunko.project.java.dao;

public class Dao {

    private static Dao dao;

    private Dao(){
        roles = new RolesDao();
        user = new UserDao();
        tours = new ToursDao();
    }

    public RolesDao roles;
    public UserDao user;
    public ToursDao tours;

    public static void reset(){
        C_Init.main(new String[]{});
    }

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }


}
