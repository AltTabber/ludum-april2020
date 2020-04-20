package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.models.FlareGunModel;
import ru.alttabber.ludum.memory.Game;

public class FlareGunItem extends Item {

    FlareGunModel model;

    @Override
    public void init(Batch batch) {
        super.init(batch);
        model = FlareGunModel.getInstance();

        this.width = 100;
        this.height = 100;

        this.sprite = createScaledSprite(model.getTexture());

        this.XY.x = 400;
        this.XY.y = 600;

        this.rectangle = new Rectangle(XY.x, XY.y, width, height);

        this.instruction = "Press Z to shot flare";

    }

    @Override
    public void doMapAction() {
        Game.getInstance().getPlayer().addHp(10);
        Game.getInstance().getMaskedCircle().setAlpha(0);
        Game.getInstance().getSoundManager().playFlareSound();
        destroyItem();
    }
}
