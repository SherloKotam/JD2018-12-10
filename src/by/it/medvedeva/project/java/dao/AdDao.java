package by.it.medvedeva.project.java.dao;

import by.it.medvedeva.project.java.beans.Ad;
import by.it.medvedeva.project.java.dao.UniversalDao;

public class AdDao extends UniversalDao<Ad> {
    public  AdDao(){
        super(Ad.class, "ads");
    }

}
