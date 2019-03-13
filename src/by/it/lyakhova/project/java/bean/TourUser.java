package by.it.lyakhova.project.java.bean;

public class TourUser {

    private long id;
    private long tours_id;
    private long users_id;

    public TourUser(){}

    public TourUser(long id, long tours_id, long users_id){
        this.id = id;
        this.tours_id = tours_id;
        this.users_id = users_id;
    }

    public long getId() { return id; }

    public long getTours_id() { return tours_id; }

    public long getUsers_id() { return users_id; }

    public void setId(long id) { this.id = id; }

    public void setTours_id(long tours_id) { this.tours_id = tours_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "TourUser{"+
                "id = " + id +
                ", tour_id = " + tours_id +
                ", user_id = " + users_id;
    }
}
