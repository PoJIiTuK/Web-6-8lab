package ua.lviv.iot.model;

public class Sing {


    private Integer id;
    private String singName;

    public Sing(Integer id, String singName) {
        this.id = id;
        this.singName = singName;
    }

    public Sing(String singName) {
        this(null, singName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingName() {
        return singName;
    }

    public void setSingName(String singName) {
        this.singName = singName;
    }


    @Override
    public String toString() {
        return "\nAirline: " +
                "id:" + id + ", singName:" + singName;
    }

}
