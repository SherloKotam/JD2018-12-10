package by.it.medvedeva.jd03_03.dao;

import by.it.medvedeva.jd03_03.beans.Ad;

public class AdDao extends UniversalDao <Ad> {
    public  AdDao(){
        super(Ad.class, "ads");
    }

}
