package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class Ghost extends Unit {

    Texture texture;
    Sprite sprite;


    @Override
    public void init(Batch batch) {

        this.batch = batch;

        this.XY.x = 800;
        this.XY.y = 200;

        this.width = 500;
        this.height = 500;

        this.texture = GameController.getInstance().getAssetManager().get(Assets.ghostTexture);
        this.sprite = createScaledSprite(texture);


    }

    @Override
    public void draw() {
        this.sprite.setPosition(this.XY.x, this.XY.y);
        this.sprite.draw(batch);
    }

}
