package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.gameobjects.units.Item;

public class SwordItem extends Item {

    @Override
    public void init(Batch batch) {
        super.init(batch);
        this.texture = GameController.getInstance().getAssetManager().get(Assets.swordTexture, Texture.class);

        this.width = 100;
        this.height = 100;

        this.sprite = createScaledSprite(texture);

        this.XY.x = 400;
        this.XY.y = 200;

        this.rectangle = new Rectangle(XY.x, XY.y, width, height);
    }



}
