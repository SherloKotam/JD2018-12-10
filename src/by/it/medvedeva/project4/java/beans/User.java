package by.it.medvedeva.project4.java.beans;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int roles_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getroles_id() {
        return roles_id;
    }

    public void setroles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                roles_id == user.roles_id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, roles_id);
    }

    public User(int i, String login, String password, String email, int roles_id) {
        this.id =  id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_id=" + roles_id +
                "}";
    }
}


