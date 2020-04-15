package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import ru.alttabber.ludum.abstracts.GameObject;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

import java.util.ArrayList;
import java.util.List;

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

    public void setFrameDuration(float frameDuration){
        animation.setFrameDuration(frameDuration);
    }

    public Sprite getKeyFrame(float time){
        return animation.getKeyFrame(time, true);
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
        this.x = 0;
        this.y = 0;
    }
}
