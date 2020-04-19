package ru.alttabber.ludum.scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.items.SwordItem;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;

public class SecondScene extends Scene {

    Player player;
    Item swordItem;

    @Override
    public void init(Batch batch) {
        super.init(batch);
        player = GameController.getInstance().getPlayer();

        swordItem = new SwordItem();
        swordItem.init(batch);

    }

    @Override
    public void draw() {
        this.player.draw();
        this.swordItem.draw();
    }

}
