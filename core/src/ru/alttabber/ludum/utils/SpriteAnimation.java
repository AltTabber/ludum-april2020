package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.gameobjects.GameObject;
import ru.alttabber.ludum.memory.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SpriteAnimation extends GameObject {

    private Animation<Sprite> animation;

    List<Sprite> spriteList;

    float time = 0;

    public SpriteAnimation(String[] assets, int width, int height) {
        this(assets, width, height, 0.2f);
    }

    public SpriteAnimation(String[] assets, int width, int height, float frameDuration) {
        this.width = width;
        this.height = height;

        spriteList = new ArrayList<>();

        for(String assetPath: assets){
            Texture texture = GameController.getInstance().getAssetManager().get(assetPath);
            Sprite sprite = createScaledSprite(texture);
            spriteList.add(sprite);
        }

        animation = new Animation<Sprite>(frameDuration, spriteList.toArray(new Sprite[spriteList.size()]));
        animation.setPlayMode(Animation.PlayMode.LOOP);

    }

    public void transformSprites(Consumer<Sprite> transformation){
        for(Sprite sprite : animation.getKeyFrames()){
            transformation.accept(sprite);
        }
    }

    public void setFrameDuration(float frameDuration){
        animation.setFrameDuration(frameDuration);
    }

    public Animation<Sprite> getAnimation() {
        return animation;
    }

    public Sprite getKeyFrame(float time){
        return animation.getKeyFrame(time, true);
    }

    public float getFrameDuration() {
        return animation.getFrameDuration();
    }

    @Override
    public void draw() {
        time += Gdx.graphics.getDeltaTime();
        animation.getKeyFrame(time, true).setPosition(50, 50);
        animation.getKeyFrame(time, true).draw(batch);
    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;
        this.XY.x = 0;
        this.XY.y = 0;
    }
}
