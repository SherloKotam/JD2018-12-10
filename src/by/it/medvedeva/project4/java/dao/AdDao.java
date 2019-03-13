package by.it.medvedeva.project4.java.dao;

import by.it.medvedeva.project4.java.beans.Ad;

public class AdDao extends UniversalDao<Ad> {
    public  AdDao(){
        super(Ad.class, "ads");
    }

}
