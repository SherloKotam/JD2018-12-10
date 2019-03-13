package by.it.zagurskaya.project.java.beans;

//import java.util.Date;
import java.sql.Date;

public class Kassa implements Entity {
    private long id;
    private long currencyId; // long currencyId
    private double received;
    private double coming;
    private double spending;
    private double transmitted; // transmitted
    private double balance;
    private long userId; //userId
    private Date date;
    private long dutiesId; // int dutiesNumber

    public Kassa() {
    }

    public Kassa(long id, long currencyId, double received, double coming, double spending, double transmitted, double balance, long userId, Date date, long dutiesId) {
        this.id = id;
        this.currencyId = currencyId;
        this.received = received;
        this.coming = coming;
        this.spending = spending;
        this.transmitted = transmitted;
        this.balance = balance;
        this.userId = userId;
        this.date = date;
        this.dutiesId = dutiesId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public double getReceived() {
        return received;
    }

    public void setReceived(double received) {
        this.received = received;
    }

    public double getComing() {
        return coming;
    }

    public void setComing(double coming) {
        this.coming = coming;
    }

    public double getSpending() {
        return spending;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }

    public double getTransmitted() {
        return transmitted;
    }

    public void setTransmitted(double transmitted) {
        this.transmitted = transmitted;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDutiesId() {
        return dutiesId;
    }

    public void setDutiesId(long dutiesId) {
        this.dutiesId = dutiesId;
    }

    @Override
    public String toString() {
        return "Kassa{" +
                "id=" + id +
                ", currencyId=" + currencyId +
                ", received=" + received +
                ", coming=" + coming +
                ", spending=" + spending +
                ", transmitted=" + transmitted +
                ", balance=" + balance +
                ", userId=" + userId +
                ", date=" + date +
                ", dutiesId=" + dutiesId +
                '}';
    }
}
