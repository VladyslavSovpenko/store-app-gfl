package entity;

import utils.ConfigReader;

import java.time.LocalDate;

public class Souvenir implements Entity {

    private Integer id;
    private String name;
    private Producer producer;
    private Double price;
    private LocalDate creationDate;
    private static ConfigReader configReader = ConfigReader.getInstance();
    private static Integer nextId = configReader.getInt("souvenir");

    public Souvenir() {
    }

    public Souvenir(String name, Producer producer, Double cost, int day, int month, int year) {
        this.id = nextId++;
        configReader.set("souvenir", String.valueOf(nextId));
        this.name = name;
        this.producer = producer;
        this.price = cost;
        
        LocalDate currentDate = LocalDate.now();
        LocalDate creationDate = LocalDate.of(year, month, day);
        if (creationDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("Creation date cannot be in the future.");
        }
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer=" + producer +
                '}';
    }
}
