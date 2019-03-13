package by.it.moroz.jd03.project.java.beans;

public class Order {
    
    private long id;
    private long menu_id;
    private int count;
    private double check;
    private long users_id;

    public Order() {
    }

    public Order(long id, long menu_id, int count, double check, long users_id) {
        this.id = id;
        this.menu_id = menu_id;
        this.count = count;
        this.check = check;
        this.users_id = users_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getMenu_id() { return menu_id; }

    public void setMenu_id(long menu_id) { this.menu_id = menu_id; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public double getCheck() { return check; }

    public void setCheck(double check) { this.check = check; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", menu_id=" + menu_id +
                ", count=" + count +
                ", check=" + check +
                ", users_id=" + users_id +
                '}';
    }
}
