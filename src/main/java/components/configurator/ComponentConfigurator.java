package components.configurator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import components.Component;
import entities.Entity;

import static components.configurator.ComponentTypes.SPRITE_RENDERER;
/**
 * This class is responsible for configuring the components of an entity.
 * It is used by the EntityFactory class.
 * It uses the ConfiguratorTemplate class to configure the components.
*/

public abstract class ComponentConfigurator {
    private static ConfiguratorTemplate configurator;
    public static void configure(Entity entity, String fileName) {
        // read the json file
        JsonObject jsonElement = JsonUtils.read(fileName);
        // get a JsonArray components of the entity
        JsonArray components = jsonElement.getAsJsonArray("components");
        // execute the configurator for each component
        executeConfigurator(entity, components);

    }

    // This method is used to execute the configurator for each component.
    // because each component has its own configurator.
    private static void executeConfigurator(Entity entity, JsonArray components) {
        for (JsonElement component : components) {
            if (component.isJsonObject()) {
                JsonObject componentObject = component.getAsJsonObject();
                String componentType = componentObject.get("type").getAsString();
                if (!entity.hasComponent(componentType)) {
                    continue;
                }
                Component currentComponent = entity.getComponentByClassName(componentType);

                switch (componentType) {
                    case SPRITE_RENDERER -> {
                        configurator = new ConfigureSpriteRender();
                    }
            }
                configurator.configure(currentComponent, componentObject);
            }
        }


    }



}


