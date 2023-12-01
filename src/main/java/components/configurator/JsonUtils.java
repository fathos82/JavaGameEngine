package components.configurator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;


public final class JsonUtils {
    private JsonUtils() {}
    public static JsonObject read(String fileName) {
        InputStream is = ConfiguratorTemplate.class.getResourceAsStream(fileName);
        assert is != null;
        JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(is)).getAsJsonObject();
        if (!jsonObject.isJsonObject()) {
            throw new RuntimeException("Invalid JSON file");
        }
        return jsonObject;
    }
    @SuppressWarnings("unchecked")
    public static  List<Float> convertJsonArrayToFloatList(JsonArray jsonArray) {
        List<Float> list = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            list.add(jsonElement.getAsFloat());
        }
        return list;

    }
}
