package by.it.yarmolenka.project.java.beans;

public class Bet {
    private long id;
    private double amount;
    private double payout;
    private long fk_users;
    private long fk_events;

    public Bet() {
    }

    public Bet(long id, double amount, double payout, long fk_users, long fk_events) {
        this.id = id;
        this.amount = amount;
        this.payout = payout;
        this.fk_users = fk_users;
        this.fk_events = fk_events;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getPayout() {
        return payout;
    }

    public long getFk_users() {
        return fk_users;
    }

    public long getFk_events() {
        return fk_events;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayout(double payout) {
        this.payout = payout;
    }

    public void setFk_users(long fk_users) {
        this.fk_users = fk_users;
    }

    public void setFk_events(long fk_events) {
        this.fk_events = fk_events;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", amount=" + amount +
                ", payout=" + payout +
                ", fk_users=" + fk_users +
                ", fk_events=" + fk_events +
                '}';
    }
}
