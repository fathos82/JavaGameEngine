package components;

import entities.Entity;
import renderer.Animation;
import renderer.Animator;
import renderer.RenderableObject;
import renderer.Renderer;
import texture.*;

import java.awt.*;
import java.util.List;

public class SpriteRendererComponent extends Component implements RenderableObject {
    private Animator animator;
    // Todo: temporary attributes:
    private int width = 64;
    private int height = 40;
    private String textureFileName = TextureConstants.DEFAULT_PLAYER_TEXTURE;


    public SpriteRendererComponent(Entity entity) {
        super(entity);
        animator = new Animator();
        Renderer.addRenderableObject(this);

    }





    public void createAnimation (String name, List<Float> framesTime, int animationSpeed, boolean isLoop){
        Texture texture = new Texture(textureFileName);
        int row = animator.getCountAnimation();
        System.out.println(row);
        SpriteSheet spriteSheet = new SpriteSheet(width, height, texture, row, entity.getTransform());
        Animation animation = new Animation(spriteSheet, framesTime, animationSpeed, isLoop);
        animator.addAnimation(name, animation);
    }



    public void setAnimation(String name, Animator.From from){
        this.animator.setAnimation(name, from);
    }
    @Override
    public void init() {
//        Renderer.addRenderableObject(this);
    }

    @Override
    public void render(Graphics g) {
        animator.getCurrentFrame().sprite().render(g);
    }

    @Override
    public void update() {
        animator.update();


    }


}
