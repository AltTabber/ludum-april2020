package ru.alttabber.ludum.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.utils.TextContainer;
import ru.alttabber.ludum.window.Window;

public class GameOverScene extends Scene {


    Batch textBatch;
    @Override
    public void init(Batch batch) {
        textBatch = new SpriteBatch();
        super.init(textBatch);

    }

    @Override
    public void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "Game Over!");
        TextContainer.getHeaderLabelFont().draw(this.batch, "Game Over!", Window.getWidth()/2 - TextContainer.getLayout().width/2, 500);

        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "Please restart game.");
        TextContainer.getHeaderLabelFont().draw(this.batch, "Please restart game.", Window.getWidth()/2 - TextContainer.getLayout().width/2, 460);
        this.batch.end();
    }
}
