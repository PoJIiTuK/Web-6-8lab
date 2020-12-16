package ua.lviv.iot.model;

import java.util.Date;

public class MusicLable {

    private Integer id;
    private Integer performerId;
    private String director;
    private Integer budget;



    public MusicLable(Integer id, Integer performerId, String director, Integer budget) {
        this.id = id;
        this.performerId = performerId;
        this.director = director;
        this.budget = budget;
    }

    public MusicLable(Integer performerId, String director, Integer budget) {
        this(null, performerId, director, budget);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerIdId) {
        this.performerId = performerIdId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "\nMusicLable: " +
                "id:" + id +
                ", airlineId" + performerId +
                ", departureAirportId:" + director +
                ", arrivalAirportId:" + budget;
    }
}
