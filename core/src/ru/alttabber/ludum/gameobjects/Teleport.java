package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.scene.CongratulationScene;
import ru.alttabber.ludum.window.Window;

public class Teleport extends AutomaticUsableObject {

    public Teleport(float x, float y) {
        this.XY.x = x;
        this.XY.y = y;
    }

    private Texture texture;

    @Override
    public void draw() {
        //нет отрисовки, но можно отрисовать дверь
        super.draw();
        batch.draw(texture, XY.x, XY.y, width, height);
    }

    @Override
    public void init(Batch batch) {
        super.init(batch);

        this.width = 150;
        this.height = 150;

        this.rect = new Rectangle(XY.x, XY.y, this.width, this.height);

        Pixmap pixmap = new Pixmap((int) this.width, (int) this.height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillRectangle(0, 0, (int) width, (int) height);
        texture = new Texture(pixmap);
        pixmap.dispose();

    }

    @Override
    public void doMapAction() {
        CongratulationScene level = (CongratulationScene) GameController.getInstance().getLevelController().chooseLevel(CongratulationScene.class);
        level.init(batch);
        Player player = GameController.getInstance().getPlayer();
        GameController.getInstance().getPlayer().setXY(Window.getWidth() - player.width, player.XY.y );
    }
}
