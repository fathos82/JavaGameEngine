package components.configurator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import components.Component;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

// Template Method:
public abstract class ConfiguratorTemplate {
    public void configure(Component component, JsonObject componentObject){
        // it's a recipe of cake of all configuration Class:
        // this method is a template method
        configureCommonAttributes(component, componentObject);
        configureImpl(component, componentObject);    }

    public abstract void configureImpl(Component component, JsonObject componentObject);

    private void configureCommonAttributes(Component component, JsonObject componentObject) {
        // Esta Classe Literalmente percorre os Atributes do Componente no json e sete os valores na classe
        // Problema: Não e checado se o atributo existe na classe, apenas Ignora
        JsonObject classAttributes = componentObject.getAsJsonObject("ClassAttributes");
        Set<Map.Entry<String, JsonElement>> entries = classAttributes.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value.isJsonPrimitive()) {
                setBasicAttribute(component, key, value);
            }
            else {
                setAdvancedAttribute();

            }
        }
    }
    private void setBasicAttribute(Component component , String key, JsonElement value) {
        try {
            Field field = component.getClass().getDeclaredField(key);
            field.setAccessible(true);
            if (value.getAsJsonPrimitive().isNumber()) {
                field.set(component, value.getAsInt());
            } else if (value.getAsJsonPrimitive().isBoolean()) {
                field.set(component, value.getAsBoolean());
            } else if (value.getAsJsonPrimitive().isString()) {
                field.set(component, value.getAsString());
            }
            System.out.println(field.getName() + " " + field.get(component));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Ignore
        }
    }

    private void setAdvancedAttribute() {
        // without case for now
    }
}
