package org.example.entity;

public class Evenement {

    private Integer id;
    private String name;
    private String date;
    private String location;
    private String description;

    public Evenement(){
    }

    private Evenement(Integer id , String name , String date , String location , String description){
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
