package by.it.lyakhova.project.java.bean;

public class Role {

    private long id;
    private String role;
    private String description;

    public Role(){}

    public Role(long id, String role, String description){
        this.id = id;
        this.role = role;
        this.description = description;
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }



    @Override
    public String toString() {

        return "Role{id=" + id + ", role=" + role + ", description=" + description + "}";
    }
}
