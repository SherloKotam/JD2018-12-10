package by.it.medvedeva.project4.java.beans;

import java.util.Objects;

public class Ad {
    private int id;
    private String description ;
    private  String  address;
    private int floor;
    private  int floors;
    private int rooms;
    private  double area;
    private double price;
    private int users_id;

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

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
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

    public int getusers_id() {
        return users_id;
    }

    public void setusers_id(int users_id) {
        this.users_id = users_id;
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
                users_id == ad.users_id &&
                Objects.equals(description, ad.description) &&
                Objects.equals(address, ad.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, address, floor, floors, rooms, area, price, users_id);
    }

    public Ad(int id, String description, String address, int floor, int floors, int rooms, double area, double price, int users_id) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.floor = floor;
        this.floors = floors;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.users_id = users_id;
    }

    public Ad() {
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}



