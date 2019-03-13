package by.it.medvedeva.project4.java.dao;

import by.it.medvedeva.project4.java.beans.Housead;

public class HouseadDao extends UniversalDao<Housead> {
    public  HouseadDao(){
        super(Housead.class, "houseads");
    }


}
