package ru.alttabber.ludum.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.utils.TextContainer;
import ru.alttabber.ludum.window.Window;

public class CongratulationScene extends Scene {

    Batch textBatch;

    @Override
    public void init(Batch batch) {
        textBatch = new SpriteBatch();
        super.init(textBatch);

    }

    @Override
    public void draw() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "Congratulation!");
        TextContainer.getHeaderLabelFont().draw(this.batch, "Game Over!", Window.getWidth()/2 - TextContainer.getLayout().width/2, 500);

        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "You escape and keep alive.");
        TextContainer.getHeaderLabelFont().draw(this.batch, "Please restart game.", Window.getWidth()/2 - TextContainer.getLayout().width/2, 460);
        this.batch.end();

    }

}
