package by.it.yarmolenka.project.java.beans;

public class User {
    private long id;
    private String login;
    private String email;
    private String password;
    private double cashier;
    private long fk_roles;

    public User() {
    }

    public User(long id, String login, String email, String password, double cashier, long fk_roles) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.cashier = cashier;
        this.fk_roles = fk_roles;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getCashier() {
        return cashier;
    }

    public long getFk_roles() {
        return fk_roles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCashier(double cashier) {
        this.cashier = cashier;
    }

    public void setFk_roles(long fk_roles) {
        this.fk_roles = fk_roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cashier=" + cashier +
                ", fk_roles=" + fk_roles +
                '}';
    }
}
