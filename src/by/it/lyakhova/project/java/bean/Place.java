package by.it.lyakhova.project.java.bean;

public class Place {

    private long id;
    private String country;
    private String town;

    public Place(){}

    public Place(long id, String country, String town){
        this.id = id;
        this.country = country;
        this.town = town;

    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Tour_Type{" +
                "id = " + id +
                ", country = " + country +
                ", town = " + town;
    }
}
