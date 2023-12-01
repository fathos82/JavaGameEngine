package texture;

import entities.Transform;
import renderer.RenderableObject;

import java.awt.*;

public class Sprite implements RenderableObject {
    private final Texture texture;
    public Transform transform;

    public Sprite(Texture texture, Transform transform) {
        this.texture = texture;
        this.transform = transform;
    }


    @Override
    public void render(Graphics g) {

        g.drawImage(texture.getImage(), (int) transform.position.x, (int) transform.position.y, 128, 80, null);
    }

    public Texture getTexture() {

        return texture;
    }
}
