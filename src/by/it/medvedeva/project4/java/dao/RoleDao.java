package by.it.medvedeva.project4.java.dao;

import by.it.medvedeva.project4.java.beans.Role;

public class RoleDao extends UniversalDao<Role> {
    public  RoleDao(){
        super(Role.class, "roles");
    }

}
