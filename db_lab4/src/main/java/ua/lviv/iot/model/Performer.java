package ua.lviv.iot.model;


public class Performer {

    private Integer id;
    private String name;
    private String surname;
    private String country;

    public Performer(Integer id, String name, String surname, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Performer( String name, String surname, String country) {
        this(null, name, surname, country);
    }

    public Performer(String name, String surname) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surname;
    }

    public void setSurName(String surname) {
        this.surname = surname;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nPerformer: " +
                "id:" + id +
                ", name" + name +
                ", surname:" + surname +
                ", country:" + country;
    }
}
    
