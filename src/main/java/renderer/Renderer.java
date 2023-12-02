package renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public final class Renderer {
    private static List<RenderableObject> renderableObjects = new ArrayList<>();

    public static void render(Graphics g) {
        try {
            if (!renderableObjects.isEmpty()) {
                for (RenderableObject renderableObject : renderableObjects) {
                    renderableObject.render(g);
                }
            }
        } catch (Exception ignored){
        }
    }
    public static void addRenderableObject(RenderableObject renderableObject) {
        renderableObjects.add(renderableObject);
    }

}