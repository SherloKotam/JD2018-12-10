package by.it.lyakhova.project.java.bean;

public class TourText {

    private long id;
    private String name;
    private String tour_type;
    private String country;
    private String town;
    private String transport;
    private String housing;
    private int price;
    private String date;
    private int duration;
    private int hot;
    private int discount;

    public TourText(){}

    public TourText(long id, String name, String tour_type, String country, String town, String transport,
                    String housing, int price, String date, int duration, int hot, int discount){
        this.id = id;
        this.name = name;
        this.tour_type = tour_type;
        this.country = country;
        this.town = town;
        this.transport = transport;
        this.housing = housing;
        this.price = price;
        this.date = date;
        this.duration = duration;
        this.hot = hot;
        this.discount = discount;
    }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getTour_type() { return tour_type; }

    public String getCountry() { return country; }

    public String getTransport() { return transport; }

    public String getHousing() { return housing; }

    public int getPrice() { return price; }

    public String getDate() { return date; }

    public int getDuration() { return duration; }

    public int getHot() { return hot; }

    public int getDiscount() { return discount; }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setTour_type(String tour_type) { this.tour_type = tour_type; }

    public void setCountry(String country) { this.country = country; }

    public void setTransport(String transport) { this.transport = transport; }

    public void setHousing(String housing) { this.housing = housing; }

    public void setPrice(int price) { this.price = price; }

    public void setDate(String date) { this.date = date; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setHot(int hot) { this.hot = hot; }

    public void setDiscount(int discount) { this.discount = discount; }

    @Override
    public String toString() {
        return "TourText{" +
                "id = " + id +
                ", name = " + name +
                ", tour_type = " + tour_type +
                ", country = " + country +
                ", town = " + town +
                ", transport = " + transport +
                ", housing = " + housing +
                ", price = " + price +
                ", date = " + date +
                ", duration = " + duration +
                ", hot = " + hot +
                ", discount = " + discount;
    }
}
