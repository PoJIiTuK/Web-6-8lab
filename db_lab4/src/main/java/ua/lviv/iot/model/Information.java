package ua.lviv.iot.model;

import java.util.Date;

public class Information {

    private Integer id;
    private Integer singId;
    private String year;
    private String time_code;

    public Information(Integer id, Integer singId, String year, String time_code) {
        this.id = id;
        this.singId = singId;
        this.year = year;
        this.time_code = time_code;
    }

    public Information( Integer singId, String year, String time_code) {
        this(null, singId, year, time_code);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingId() {
        return singId;
    }

    public void setSingId(Integer singId) {
        this.singId = singId;
    }

    public String getYear() { return year; }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTimeCode() { return time_code; }

    public void setTimeCode(String time_code) {
        this.time_code = time_code;
    }

    @Override
    public String toString() {
        return "\nInformation: " +
                "id:" + id + ", singId:" + singId + ", year:" + year + ", time_code:" + time_code;
    }
}
