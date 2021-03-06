package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.models.CompassModel;
import ru.alttabber.ludum.memory.Game;

public class CompassItem extends Item {

    CompassModel model;

    @Override
    public void init(Batch batch) {
        super.init(batch);
        model = CompassModel.getInstance();

        this.width = 100;
        this.height = 100;

        this.sprite = createScaledSprite(model.getTexture());

        this.XY.x = 400;
        this.XY.y = 600;

        this.rectangle = new Rectangle(XY.x, XY.y, width, height);

        this.instruction = "Press Z to show direction of key and exit.";
    }

    @Override
    public void doMapAction() {
        Game.getInstance().getCompassUI().setAlpha(0.5f);
        Game.getInstance().getSoundManager().playCompassSound();
        this.destroyItem();
    }

}
