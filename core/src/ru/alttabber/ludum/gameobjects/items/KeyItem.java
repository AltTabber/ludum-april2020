package ru.alttabber.ludum.gameobjects.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.models.KeyModel;
import ru.alttabber.ludum.memory.ExitState;
import ru.alttabber.ludum.memory.Game;

public class KeyItem extends Item {

    KeyModel model;

    @Override
    public void init(Batch batch) {
        super.init(batch);
        model = KeyModel.getInstance();

        this.width = 70;
        this.height = 70;

        this.sprite = createScaledSprite(model.getTexture());

        this.spriteInventory = createScaledSprite(model.getTexture(), 50,  50);

        this.XY.x = 400;
        this.XY.y = 600;

        this.rectangle = new Rectangle(XY.x, XY.y, width, height);
    }

    @Override
    public void doMapAction() {
        super.doMapAction();
        Game.getInstance().setExitState(ExitState.EXIT_OPEN);
    }
}
