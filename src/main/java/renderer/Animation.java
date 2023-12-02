package renderer;

import texture.SpriteSheet;

import java.util.ArrayList;
import java.util.List;

public class Animation {

    private SpriteSheet spriteSheet;


    /**
     * Animation frames per second
     */
    private float animationSpeed;
    private int frameCount;
    private boolean isLoop;
    private List<Frame> frames;

    public Animation(SpriteSheet spriteSheet, List<Float> framesTime, int animationSpeed, boolean isLoop) {


        assert spriteSheet.getCount()  == framesTime.size() : "ERROR: The number of framesTime must be equal to the number of sprites in the spriteSheet";
        this.spriteSheet = spriteSheet;
        frames = new ArrayList<>();

        for(int i = 0; i < spriteSheet.getCount(); i++){
            frames.add(new Frame(spriteSheet.getSpriteByIndex(i), framesTime.get(i)));
        }

        this.frameCount = spriteSheet.getCount();
        this.animationSpeed = animationSpeed;
        this.isLoop = isLoop;
    }
    public Frame getFrame(int frameIndex) {
        return frames.get(frameIndex);
    }

    public int getFrameCount() {
        return frameCount;
    }

    public boolean isLoop() {
        return isLoop;
    }

    public float getAnimationSpeed() {
        return animationSpeed;
    }
}
