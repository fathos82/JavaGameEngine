package entities;

import components.PhysicsComponent;
import components.configurator.ComponentConfigurator;
import components.SpriteRendererComponent;
import entities.player.Player;

public final class EntityFactory {
    @SuppressWarnings("unchecked")
    public static <T extends Entity> T createEntity(EntityType type) {
        switch (type) {
            case PLAYER:
                Entity player = new Player(SpriteRendererComponent.class, PhysicsComponent.class);
                ComponentConfigurator.configure(player,"/player_configs.json" );
                return (T) player;
            default:
                throw new RuntimeException("Invalid entity type");

        }

    }

    public enum EntityType {
        PLAYER, ENEMY
    }




}
