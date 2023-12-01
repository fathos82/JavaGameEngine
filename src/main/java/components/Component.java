package components;

import entities.Entity;

public abstract class Component {
    protected Entity entity;

    public Component(Entity entity) {
        this.entity = entity;
    }
    public abstract void update();

    /*
    Why Init?
    Because I Don't wanna start a few action before a time,
    For exemplo:
    In the SpriteRendererComponent, I don't wanna add the object to the renderableObjects list before the animation is created.
    the animation is created in class of Configurations, in the method specificClassConfigurations of components/configs/EntityConfigs.

    */
    public abstract void init();
}
