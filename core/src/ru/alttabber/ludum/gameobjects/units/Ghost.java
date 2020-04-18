package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class Ghost extends Unit {

    Texture texture;
    Sprite sprite;

    float speed;

    @Override
    public void init(Batch batch) {

        this.batch = batch;

        this.XY.x = 800;
        this.XY.y = 200;

        this.width = 300;
        this.height = 300;

        this.texture = GameController.getInstance().getAssetManager().get(Assets.ghostTexture);
        this.sprite = createScaledSprite(texture);

        this.speed = 50;

    }

    @Override
    public void draw() {
        Vector2 movementTarget = GameController.getInstance().getPlayer().getSpriteCenter();

        Vector2 velocityVector = this.getSpriteCenter().sub(movementTarget).nor();

        this.XY.add(-1 * velocityVector.x * this.speed * Gdx.graphics.getDeltaTime(),
                -1 * velocityVector.y * this.speed * Gdx.graphics.getDeltaTime());

        this.sprite.setPosition(this.XY.x, this.XY.y);
        this.sprite.draw(batch);
    }

}
