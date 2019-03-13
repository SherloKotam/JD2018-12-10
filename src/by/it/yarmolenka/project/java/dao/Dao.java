package by.it.yarmolenka.project.java.dao;

public class Dao {

    private volatile static Dao dao;

    public RoleDao role;
    public UserDao user;
    public BetDao bet;
    public EventDao event;
    public RaceDao race;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        bet = new BetDao();
        event = new EventDao();
        race = new RaceDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        }
        return dao;
    }

    public void resetDatabase(){
        ResetData.reset();
    }
}
