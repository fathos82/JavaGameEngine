package components;

import entities.Entity;
import org.example.game.Time;

public class PhysicsComponent extends Component {

    private final float gravity;
    private  float velocityY;
    private final float speed;
    private final float jumpForce;



    private boolean onGround;
    public PhysicsComponent(Entity entity) {
        super(entity);
        gravity = 100f;
        velocityY = 0;
        speed = 10;
        jumpForce = 70f;
        onGround = false;
    }

    private void applyGravity() {
        if (onGround) {
            return;
        }
        float deltaY = velocityY * Time.deltaTime() + 0.5f * gravity * Time.deltaTime() * Time.deltaTime();
        velocityY += gravity * Time.deltaTime();
        entity.getTransform().position.y += deltaY;
    }
    public void jump() {
        if (onGround) {
            velocityY = - jumpForce;
            onGround = false;
        }
    }

    @Override
    public void update() {
        checkIsOnGround();
        applyGravity();
    }

    private void checkIsOnGround() {
    }
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public void init() {
    }

}
