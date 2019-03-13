package by.it.lyakhova.project.java.bean;

public class User {

    private long id;
    private String login;
    private String email;
    private String password;
    private String contacts;
    private long roles_id;

    public User(){}

    public User(long id, String login, String password, String email, String contacts, long roles_id){
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.contacts = contacts;
        this.roles_id = roles_id;
    }

    public void setId(long id) { this.id = id; }

    public void setLogin(String login) { this.login = login; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setRoles_id(long roles_id) { this.roles_id = roles_id; }

    public void setContacts(String contacts) { this.contacts = contacts; }


    public long getId() { return id; }

    public String getLogin() { return login; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public long getRoles_id() { return roles_id; }

    public String getContacts() { return contacts; }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contacts='" + contacts + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
