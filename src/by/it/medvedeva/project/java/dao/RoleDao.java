package by.it.medvedeva.project.java.dao;

import by.it.medvedeva.project.java.beans.Role;
import by.it.medvedeva.project.java.dao.UniversalDao;

public class RoleDao extends UniversalDao<Role> {
    public  RoleDao(){
        super(Role.class, "roles");
    }

}
