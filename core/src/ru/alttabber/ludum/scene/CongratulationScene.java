package ru.alttabber.ludum.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();
        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "Congratulation!");
        TextContainer.getHeaderLabelFont().draw(this.batch, "Congratulation!", Window.getWidth()/2 - TextContainer.getLayout().width/2, 500);

        TextContainer.getLayout().setText(TextContainer.getHeaderLabelFont(), "You escape and keep alive.");
        TextContainer.getHeaderLabelFont().draw(this.batch, "You escaped and stayed alive.", Window.getWidth()/2 - TextContainer.getLayout().width/2, 460);


        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "Thanks for discord guys:");
        TextContainer.getInstructionFont().draw(this.batch, "Thanks for discord guys:", Window.getWidth()/2 - TextContainer.getLayout().width/2, 300);
        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "Without, inferno, Gost_Stelser");
        TextContainer.getInstructionFont().draw(this.batch, "Without, inferno, Gost_Stelser", Window.getWidth()/2 - TextContainer.getLayout().width/2, 250);
        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "pro100_baton, Killbuy, Rommily");
        TextContainer.getInstructionFont().draw(this.batch, "pro100_baton, Killbuy, Rommily", Window.getWidth()/2 - TextContainer.getLayout().width/2, 220);
        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "Neimzi, jeck_black123");
        TextContainer.getInstructionFont().draw(this.batch, "Neimzi, jeck_black123", Window.getWidth()/2 - TextContainer.getLayout().width/2, 190);
        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "and all from server [Bozhechki Koshechki]");
        TextContainer.getInstructionFont().draw(this.batch, "and all from server [Bozhechki Koshechki]", Window.getWidth()/2 - TextContainer.getLayout().width/2, 160);

        TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "and you... Thank you for playing!");
        TextContainer.getInstructionFont().draw(this.batch, "and you... Thank you for playing!", Window.getWidth()/2 - TextContainer.getLayout().width/2, 100);

        this.batch.end();

    }

}
