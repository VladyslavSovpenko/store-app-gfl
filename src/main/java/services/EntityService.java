package services;

import entity.Entity;

import java.util.List;

public interface EntityService {
    Entity get(String name);

    void post(Entity entity);

    void update(String name, Entity entity);

    void delete(String id);

    List<? extends Entity> getAllEntities();

    void removeAll(List<? extends Entity> entityList);
}
