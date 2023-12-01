package entities.enemies;

import entities.Entity;
import renderer.RenderableObject;
import renderer.Renderer;


import java.awt.*;

public class Enemy extends Entity implements RenderableObject {
    public Enemy() {
        super();
        Renderer.addRenderableObject(this);

    }
    @Override
    public void render(Graphics g) {

    }

    @Override
    public void update() {

    }
}
