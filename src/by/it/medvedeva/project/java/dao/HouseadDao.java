package by.it.medvedeva.project.java.dao;

import by.it.medvedeva.project.java.beans.Housead;
import by.it.medvedeva.project.java.dao.UniversalDao;

public class HouseadDao extends UniversalDao<Housead> {
    public  HouseadDao(){
        super(Housead.class, "houseads");
    }


}
