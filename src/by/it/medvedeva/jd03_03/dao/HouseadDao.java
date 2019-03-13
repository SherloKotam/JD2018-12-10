package by.it.medvedeva.jd03_03.dao;

import by.it.medvedeva.jd03_03.beans.Housead;

public class HouseadDao extends UniversalDao <Housead> {
    public  HouseadDao(){
        super(Housead.class, "houseads");
    }


}
