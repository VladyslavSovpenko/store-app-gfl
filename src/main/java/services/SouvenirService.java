package services;

import entity.Entity;
import entity.Souvenir;
import utils.Utils;

import java.util.List;

public class SouvenirService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static SouvenirService souvenirService = new SouvenirService();

    private SouvenirService() {
    }

    public static SouvenirService getInstance() {
        return souvenirService;
    }

    @Override
    public Entity get(String id) {
        return warehouse.getSouvenirById(id);
    }

    @Override
    public void post(Entity entity) {
        warehouse.saveToSouvenirs(((Souvenir) entity));
        System.out.println(Utils.SOUVENIR_ADDED);
    }

    @Override
    public void update(String id, Entity entity) {
        Souvenir souvenirById = warehouse.getSouvenirById(id);
        souvenirById.setName(((Souvenir) entity).getName());
        souvenirById.setProducer(((Souvenir) entity).getProducer());
        souvenirById.setCreationDate(((Souvenir) entity).getCreationDate());
        souvenirById.setPrice(((Souvenir) entity).getPrice());

        warehouse.saveToSouvenirs(souvenirById);
        System.out.println(Utils.SOUVENIR_UPDATED);
    }

    @Override
    public void delete(String name) {
        warehouse.deleteSouvenir(name);
        System.out.println(Utils.SOUVENIR_REMOVED);
    }

    @Override
    public List<Souvenir> getAllEntities() {
        return warehouse.getAllSouvenirs();
    }

    @Override
    public void removeAll(List<? extends Entity> entityList) {
        warehouse.getAllSouvenirs().removeAll(entityList);
    }
}
