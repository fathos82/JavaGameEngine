package entities;


import components.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static texture.TextureConstants.DEFAULT_PLAYER_TEXTURE;

public abstract class Entity {
    private final UUID ID;
    protected String pathSprite = DEFAULT_PLAYER_TEXTURE; // Todo: Temporario
    private List<Component> components;
    private Transform transform;

    public Entity() {
        EntityPool.addEntity(this);
        components = new ArrayList<>();


        ID = UUID.randomUUID();
        transform = new Transform();
        transform.position.x = 100;
        transform.position.y = 100;

    }

    @SafeVarargs
    public Entity(Class<? extends Component>... componentClasses) {
        EntityPool.addEntity(this);
        components = new ArrayList<>();
        ID = UUID.randomUUID();
        for (Class<? extends Component> componentClass : componentClasses) {
            addComponent(componentClass);
        }
    }


    public <T extends Component> T addComponent(Class<T> clazz) {
        try {
            Component component = clazz.getConstructor(Entity.class).newInstance(this);
            components.add(component);
            return clazz.cast(component);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    public <T extends Component> T getComponent(Class<T> clazz) {
        for (Component component : components) {
            if (clazz.isInstance(component)) {
                return clazz.cast(component);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponentByClassName(String className) {
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(className)) {
                return (T) component;
            }
        }
        return null;
    }
    public boolean hasComponent(String className) {
        return getComponentByClassName(className) != null;
          }

    public void update() {
    }

    protected void internalUpdate() {
        updateComponents();
        update();
    }

    private void updateComponents() {
        for (Component component : components) {
            component.update();
        }
    }

    public Transform getTransform() {
        return transform;
    }
}