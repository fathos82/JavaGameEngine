package entities.player;

import components.PhysicsComponent;
import components.SpriteRendererComponent;
import entities.Entity;
import input.Input;
import renderer.Animator;

import static java.awt.event.KeyEvent.*;


public class Player extends Entity {
    SpriteRendererComponent spriteRenderer;
    PhysicsComponent physicsComponent;

    public Player(Class<SpriteRendererComponent> spriteRenderer, Class<PhysicsComponent> physicsComponent) {

        this.spriteRenderer = this.addComponent(spriteRenderer);
        this.physicsComponent = this.addComponent(physicsComponent);
    }
    private void handle() {
        if (!physicsComponent.isOnGround()) {
            if (Input.getKeyPressed(VK_SPACE)) { //Todo: Late  needs check if it is not falling down
                physicsComponent.jump();
            }
            spriteRenderer.setAnimation("fall", Animator.From.currentFrame);
        }else if (Input.getKeyPressed(VK_D)) {
            spriteRenderer.setAnimation("walk", Animator.From.currentFrame);
        }else if (Input.getKeyPressed(VK_A)) {
            spriteRenderer.setAnimation("walk", Animator.From.currentFrame);
        } else if (Input.getKeyPressed(VK_F)) {

            spriteRenderer.setAnimation("attack", Animator.From.currentFrame);

        }
        else {
            spriteRenderer.setAnimation("idle", Animator.From.currentFrame);

        }

    }

    @Override
    public void update() {
        handle();
    }

}
