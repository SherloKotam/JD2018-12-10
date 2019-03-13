package by.it.medvedeva.project.java.beans;

import java.util.Objects;

public class Ad {
    private int id;
    private String description ;
    private  String  adress;
    private int floor;
    private  int floors;
    private int rooms;
    private  double area;
    private double price;
    private int fk_ads;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFk_ads() {
        return fk_ads;
    }

    public void setFk_ads(int fk_ads) {
        this.fk_ads = fk_ads;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id &&
                floor == ad.floor &&
                floors == ad.floors &&
                rooms == ad.rooms &&
                Double.compare(ad.area, area) == 0 &&
                Double.compare(ad.price, price) == 0 &&
                fk_ads == ad.fk_ads &&
                Objects.equals(description, ad.description) &&
                Objects.equals(adress, ad.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, adress, floor, floors, rooms, area, price, fk_ads);
    }

    public Ad(int id, String description, String adress, int floor, int floors, int rooms, double area, double price, int fk_ads) {
        this.id = id;
        this.description = description;
        this.adress = adress;
        this.floor = floor;
        this.floors = floors;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.fk_ads = fk_ads;
    }

    public Ad() {
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", adress='" + adress + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", fk_ads=" + fk_ads +
                '}';
    }
}



