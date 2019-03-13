package by.it.migunko.project.java.beans;

public class Tours {
    private long id;
    private String description;
    private String typeOfTravel;
    private String destination;
    private String hotel;
    private int countOfNights;
    private double price;
    private long users_id;

    public Tours() {
    }

    public Tours(long id, String description, String typeOfTravel, String destination,
                 String hotel,  int countOfNights, double price, long users_id) {
        this.id = id;
        this.description = description;
        this.typeOfTravel = typeOfTravel;
        this.destination = destination;
        this.hotel = hotel;
        this.countOfNights = countOfNights;
        this.price = price;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

    public void setTypeOfTravel(String typeOfTravel) {
        this.typeOfTravel = typeOfTravel;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getCountOfNights() {
        return countOfNights;
    }

    public void setCountOfNights(int countOfNights) {
        this.countOfNights = countOfNights;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Tours{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", typeOfTravel='" + typeOfTravel + '\'' +
                ", destination='" + destination + '\'' +
                ", hotel='" + hotel + '\'' +
                ", countOfNights=" + countOfNights +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}
