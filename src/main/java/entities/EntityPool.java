package entities;

import java.util.ArrayList;
import java.util.List;

public final class EntityPool {
    private EntityPool() {}
    private static List<Entity> entities = new ArrayList<>();

    public static void addEntity(Entity entity) {
        entities.add(entity);
    }
    public static void removeEntity(Entity entity) {
        entities.remove(entity);
    }
    public static void update() {
        for (Entity entity : entities) {
            entity.internalUpdate();
        }
    }
}
