package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

public class Ghost extends Unit {

    Texture texture;
    Texture textureOverlay;
    Sprite sprite;
    Sprite spriteOverlay;

    float speed;

    @Override
    public void init(Batch batch) {

        this.batch = batch;

        this.XY.x = 800;
        this.XY.y = 200;

        this.width = 300;
        this.height = 300;

        this.texture = Game.getInstance().getAssetManager().get(Assets.ghostTexture);
        this.sprite = createScaledSprite(texture);

        this.textureOverlay = Game.getInstance().getAssetManager().get(Assets.ghostOverlayTexture);
        this.spriteOverlay = createScaledSprite(textureOverlay);

        this.speed = 50;

    }

    @Override
    public void draw() {
        Vector2 movementTarget = Game.getInstance().getPlayer().getSpriteCenter();

        Vector2 velocityVector = this.getSpriteCenter().sub(movementTarget).nor();

        this.XY.add(-1 * velocityVector.x * this.speed * Gdx.graphics.getDeltaTime(),
                -1 * velocityVector.y * this.speed * Gdx.graphics.getDeltaTime());

        this.sprite.setPosition(this.XY.x, this.XY.y);
        this.sprite.draw(batch);
    }

    public void drawOnOverlay() {
        this.spriteOverlay.setPosition(this.XY.x, this.XY.y);
        this.spriteOverlay.draw(batch);
    }

}
