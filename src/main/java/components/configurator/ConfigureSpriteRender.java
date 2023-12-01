package components.configurator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import components.Component;
import components.SpriteRendererComponent;

import java.util.List;

public final class ConfigureSpriteRender extends ConfiguratorTemplate {
    @Override
    public void configureImpl(Component component, JsonObject componentObject) {
        createAnimations((SpriteRendererComponent) component, componentObject);

    }

    private void createAnimations(SpriteRendererComponent component, JsonObject componentObject) {
        JsonArray animations = componentObject.getAsJsonArray("animations");
        for (JsonElement animation : animations) {
            JsonObject animationObject = animation.getAsJsonObject();
            String name = animationObject.get("name").getAsString();
            JsonArray framesTimeJson = animationObject.getAsJsonArray("framesTime");
            List<Float> framesTime = JsonUtils.convertJsonArrayToFloatList(framesTimeJson);
            int animationSpeed = animationObject.get("animationSpeed").getAsInt();
            boolean isLoop = animationObject.get("isLoop").getAsBoolean();


            System.out.println("\nCreating animation: " + name);
            System.out.println("FramesTime: " + framesTime);
            System.out.println("AnimationSpeed: " + animationSpeed);
            System.out.println("isLoop: " + isLoop);
            System.out.println();

            component.createAnimation(name, framesTime, animationSpeed, isLoop);
        }

    }
}
