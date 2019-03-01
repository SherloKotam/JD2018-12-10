package by.it.lyakhova.jd03_02.bean;

public class Housing {

    private long id;
    private String type;

    public Housing(){}

    public Housing(long id, String type){
        this.id = id;
        this.type = type;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "housing{" +
                "id = " + id +
                ", type = " + type;
    }
}