package by.it.lyakhova.project.java.bean;

public class Tour {

    private long id;
    private String name;
    private long tour_type_id;
    private long place_id;
    private long transport_id;
    private long housing_id;
    private int price;
    private String date;
    private int duration;
    private int hot;
    private int discount;

    public Tour(){}

    public Tour(long id, String name, long tour_type_id, long place_id, long transport_id,
                long housing_id, int price, String date, int duration, int hot, int discount){
        this.id = id;
        this.name = name;
        this.tour_type_id = tour_type_id;
        this.place_id = place_id;
        this.transport_id = transport_id;
        this.housing_id = housing_id;
        this.price = price;
        this.date = date;
        this.duration = duration;
        this.hot = hot;
        this.discount = discount;
    }

    public long getId() { return id; }

    public String getName() { return name; }

    public long getTour_type_id() { return tour_type_id; }

    public long getPlace_id() { return place_id; }

    public long getTransport_id() { return transport_id; }

    public long getHousing_id() { return housing_id; }

    public int getPrice() { return price; }

    public String getDate() { return date; }

    public int getDuration() { return duration; }

    public int getHot() { return hot; }

    public int getDiscount() { return discount; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setTour_type_id(long tour_type_id) { this.tour_type_id = tour_type_id; }

    public void setPlace_id(long place_id) { this.place_id = place_id; }

    public void setTransport_id(long transport_id) { this.transport_id = transport_id; }

    public void setHousing_id(long housing_id) { this.housing_id = housing_id; }

    public void setPrice(int price) { this.price = price; }

    public void setDate(String date) { this.date = date; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setHot(int hot) { this.hot = hot; }

    public void setDiscount(int discount) { this.discount = discount; }

    @Override
    public String toString() {
        return "Tour{" +
                "id = " + id +
                ", name = " + name +
                ", tour_type_id = " + tour_type_id +
                ", place_id = " + place_id +
                ", transport_id = " + transport_id +
                ", housing_id = " + housing_id +
                ", price = " + price +
                ", date = " + date +
                ", duration = " + duration +
                ", hot = " + hot +
                ", discount = " + discount;
    }
}
