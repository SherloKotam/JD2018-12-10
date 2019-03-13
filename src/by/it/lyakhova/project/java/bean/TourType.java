package by.it.lyakhova.project.java.bean;

public class TourType {

    private long id;
    private String type;

    public TourType(){}

    public TourType(long id, String type){
        this.id = id;
        this.type = type;
    }

    public long getId() { return id; }

    public String getType() { return type; }

    public void setId(long id) { this.id = id; }

    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Tour_Type{" +
                "id = " + id +
                ", type = " + type;
    }
}
