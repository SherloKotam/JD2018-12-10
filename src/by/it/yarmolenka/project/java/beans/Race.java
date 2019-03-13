package by.it.yarmolenka.project.java.beans;

import java.sql.Timestamp;

public class Race {
    private long id;
    private Timestamp date;
    private String race_track;
    private String description;

    public Race() {
    }

    public Race(long id, Timestamp date, String race_track, String description) {
        this.id = id;
        this.date = date;
        this.race_track = race_track;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getRace_track() {
        return race_track;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setRace_track(String race_track) {
        this.race_track = race_track;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", date=" + date +
                ", race_track='" + race_track + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
