package ua.lviv.iot.model;

import java.util.Date;

public class Albom {

    private Integer id;
    private Integer number_sings;
    private Integer all_time_code;


    public Albom(Integer id, Integer number_sings, Integer all_time_code) {
        this.id = id;
        this.number_sings = number_sings;
        this.all_time_code = all_time_code;

    }

    public Albom(Integer number_sings, Integer all_time_code) {
        this(null, number_sings, all_time_code);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberSings() {
        return number_sings;
    }

    public void setNumberSings(Integer number_sings) {
        this.number_sings = number_sings;
    }

    public Integer getAllTimeCode() {
        return all_time_code;
    }

    public void setAllTimeCode (Integer all_time_code) { this.all_time_code = all_time_code; }


    @Override
    public String toString() {
        return "\nAlbom: " +
                "id=" + id +
                ", number_sings=" + number_sings +
                ", all_time_code=" + all_time_code;
    }
}
