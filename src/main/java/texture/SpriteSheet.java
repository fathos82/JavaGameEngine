// https://github.com/TheCherno/GameProgramming/blob/master/Rain/src/com/thecherno/rain/graphics/SpriteSheet.java
package texture;

import entities.Transform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpriteSheet {
    private List<Sprite> sprites;
    private final int spriteWidth;
    private final int spriteHeight;


    public SpriteSheet(int spriteWidth, int spriteHeight, Texture texture, int row, Transform transform) {
        if (texture.getWidth() % spriteWidth != 0 || row * spriteHeight > texture.getHeight()) {
            throw new RuntimeException("ERROR: "); // TODO: 10/10/2021
        }
        sprites = new ArrayList<Sprite>();

        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

        parseSprite(texture, row, transform);
    }

    private void parseSprite(Texture texture, int rows, Transform transform) {
        int y = rows * spriteHeight;
        int column = 0;
        while (spriteWidth * column < texture.getWidth()) {
            Texture subTexture = texture.getSubTexture(spriteWidth * column, y, spriteWidth, spriteHeight);
            if (!isBoundingBoxEmpty(subTexture)){
                Sprite  sprite = new Sprite(subTexture, transform);
                sprites.add(sprite);
            }
            column++;
        }
        System.out.println("Sprites: " + sprites.size());
    }
    private  boolean isBoundingBoxEmpty(Texture texture) {
        for (int i = 0; i < texture.getWidth(); i++) {
            for (int j = 0; j < texture.getHeight() ; j++) {
                if ((texture.getPixel(i, j) & 0xFF000000) != 0x00) {
                    return false;
                }
            }
        }
        // Todos os pixels no bounding box são transparentes
        return true;
    }

    public int getCount(){
        return this.sprites.size();
    }

    public Sprite getSpriteByIndex(int index){
        return this.sprites.get(index);
    }
}
