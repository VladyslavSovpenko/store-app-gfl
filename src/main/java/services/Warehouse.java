package services;

import entity.Producer;
import entity.Souvenir;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Warehouse {

    private static final Warehouse warehouse = new Warehouse();

    private List<Producer> producers = new ArrayList<>();
    private List<Souvenir> souvenirs = new ArrayList<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return warehouse;
    }

    // Producer methods
    public void saveToProducers(Producer producer) {
        producers.add(producer);
    }

    public List<Producer> getAllProducers() {
        return producers;
    }

    public Producer getProducerByName(String name) {
        return producers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(new Producer());
    }

    public Producer getProducerById(String id) {
        return producers.stream().filter(c -> c.getId() == (Integer.parseInt(id))).findFirst().orElse(new Producer());
    }

    public void deleteProducer(String id) {
        Producer customer = producers.stream().filter(c -> c.getId() == (Integer.parseInt(id))).findFirst().orElseThrow(NoSuchElementException::new);
        producers.remove(customer);
    }

    // Souvenir methods
    public void saveToSouvenirs(Souvenir souvenir) {
        souvenirs.add(souvenir);
    }

    public List<Souvenir> getAllSouvenirs() {
        return souvenirs;
    }

    public Souvenir getSouvenirByName(String name) {
        return souvenirs.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(new Souvenir());
    }

    public Souvenir getSouvenirById(String name) {
        return souvenirs.stream().filter(c -> c.getId() == (Integer.parseInt(name))).findFirst().orElse(new Souvenir());
    }

    public void deleteSouvenir(String name) {
        Souvenir souvenir = souvenirs.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
        souvenirs.remove(souvenir);
    }
}
