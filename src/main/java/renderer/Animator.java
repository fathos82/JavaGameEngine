package renderer;

import org.example.game.Time;

import java.util.HashMap;
import java.util.Map;

public class Animator {
    private Map<String, Animation> animations;
    private Animation currentAnimation;
    private Frame currentFrame;
    private float currentTime, currentFrameDuration, nextFrameTime;
    private int currentFrameIndex;

    public Animator() {
        this.animations = new HashMap<>();
        currentTime = Time.currentTime();
        nextFrameTime = currentTime;
       // currentAnimation = new NullAnimation();
    }

    public void addAnimation(String name, Animation animation) {
        if (!animations.containsKey(name)) {
            if (animations.isEmpty()) {
                System.out.println("Frame Con:" +animation.getFrameCount());
                currentAnimation = animation;
                currentFrame = animation.getFrame(0);
            }
            animations.put(name, animation);
        } else {
            throw new IllegalStateException("Animator cannot have duplicated animation.");
        }
    }

    public void setAnimation(String name, From from) {
        if (!animations.containsKey(name)) {
            throw new IllegalStateException("The Animation with name: \"" + name + "\" does not exists.");
        }
        Animation nextAnimation = animations.get(name);

        if (from == From.currentFrame) {
            if (currentAnimation.getFrameCount() > nextAnimation.getFrameCount()) {
                currentFrameIndex = 0;
            }
        } else{
            currentFrameIndex = 0;
        }
        currentAnimation = nextAnimation;


        currentFrame = currentAnimation.getFrame(currentFrameIndex);

    }

    private void nextFrame() {
        if (currentFrameIndex < (currentAnimation.getFrameCount() - 1)) {
            currentFrameIndex++;
        } else if (currentAnimation.isLoop()) {
            currentFrameIndex = 0;
            nextFrameTime = 0;
        }

        currentFrame  = currentAnimation.getFrame(currentFrameIndex);
        currentFrameDuration = currentFrame.duration() * (1f / currentAnimation.getAnimationSpeed());
    }

    private boolean canJumpToNextFrame() {
        return currentTime >= nextFrameTime;
    }

    public void update() {


        if (canJumpToNextFrame()) {
            currentTime = nextFrameTime;
            nextFrame();
            nextFrameTime += currentFrameDuration;
        }
        currentTime += Time.deltaTime();
    }

    public Frame getCurrentFrame() {
        return currentFrame;
    }
    public int getCountAnimation(){
        return animations.size();
    }

    public enum From {
        begin,
        currentFrame
    }
}
