package by.it.subach.project.java.beans;

public class User {

    private long id;
    private String login;
    private String email;
    private String password;
    private long role_id;

    public User() {
    }

    public User(long id, String login, String email, String password, long role_id) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
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

    public long getRole_id() {
        return role_id;
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

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_id='" + role_id + '\'' +
                '}';
    }
}
