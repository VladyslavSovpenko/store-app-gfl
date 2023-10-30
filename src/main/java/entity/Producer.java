package entity;

import utils.ConfigReader;

public class Producer implements Entity {

    private Integer id;
    private String name;
    private String country;
    private static ConfigReader configReader = ConfigReader.getInstance();
    private static Integer nextId = configReader.getInt("producer");

    public Producer() {
    }

    public Producer(String name, String country) {
        this.id = nextId++;
        configReader.set("producer", String.valueOf(nextId));
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
