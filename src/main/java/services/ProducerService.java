package services;

import entity.Entity;
import entity.Producer;
import utils.Utils;

import java.util.List;

public class ProducerService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static ProducerService producerService = new ProducerService();

    private ProducerService() {
    }

    public static ProducerService getInstance() {
        return producerService;
    }

    @Override
    public Entity get(String id) {
        return warehouse.getProducerById(id);
    }

    @Override
    public void post(Entity entity) {
        warehouse.saveToProducers(((Producer) entity));
        System.out.println(Utils.PRODUCER_ADDED);
    }

    @Override
    public void update(String id, Entity entity) {
        Producer producerById = warehouse.getProducerById(id);
        producerById.setName(((Producer) entity).getName());
        producerById.setCountry(((Producer) entity).getCountry());
        warehouse.saveToProducers(producerById);
        System.out.println(Utils.PRODUCER_UPDATED);
    }

    @Override
    public void delete(String name) {
        warehouse.deleteProducer(name);
        System.out.println(Utils.PRODUCER_REMOVED);
    }

    @Override
    public List<Producer> getAllEntities() {
        return warehouse.getAllProducers();
    }

    @Override
    public void removeAll(List<? extends Entity> entityList) {
        warehouse.getAllProducers().removeAll(entityList);
    }
}
