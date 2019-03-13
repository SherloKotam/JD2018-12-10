package by.it.yarmolenka.project.java.beans;

public class Event {
    private long id;
    private String description;
    private double odds;
    private long fk_races;

    public Event() {
    }

    public Event(long id, String description, double odds, long fk_races) {
        this.id = id;
        this.description = description;
        this.odds = odds;
        this.fk_races = fk_races;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getOdds() {
        return odds;
    }

    public long getFk_races() {
        return fk_races;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public void setFk_races(long fk_races) {
        this.fk_races = fk_races;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", odds=" + odds +
                ", fk_races=" + fk_races +
                '}';
    }
}
