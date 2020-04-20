package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.models.OilLampModel;
import ru.alttabber.ludum.memory.Game;

public class OilLampItem extends Item {

    OilLampModel model;

    @Override
    public void init(Batch batch) {
        super.init(batch);
        model = OilLampModel.getInstance();

        this.width = 100;
        this.height = 100;

        this.sprite = createScaledSprite(model.getTexture());

        this.XY.x = 400;
        this.XY.y = 200;

        this.rectangle = new Rectangle(XY.x, XY.y, width, height);

        this.instruction = "Press Z to add oil";
    }

    @Override
    public void doMapAction() {
        Game.getInstance().getPlayer().addLampHp(30);
        Game.getInstance().getSoundManager().playLampOilSound();
        destroyItem();
    }
}
