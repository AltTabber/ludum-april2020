package ru.alttabber.ludum.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import ru.alttabber.ludum.gameobjects.bars.BarManager;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.utils.TextContainer;
import ru.alttabber.ludum.window.Window;

public class UIOverlay{

    BarManager barManager;
    ShapeRenderer shapeRenderer;
    Batch batch;

    float time = 0;

    public void init() {
//        barManager = new BarManager();
//        barManager.addNewBar(new HitBar(GameController.getInstance().getPlayer().getHits()));
        //barManager.addNewBar(new ManaBar());
        shapeRenderer = new ShapeRenderer();

        batch = new SpriteBatch();


    }

    public void draw() {

        batch.begin();
        time += Gdx.graphics.getDeltaTime();

        if(time < 5) {
            TextContainer.getLayout().setText(TextContainer.getInstructionFont(), "Stay alive. Find a way out of here.");
            TextContainer.getInstructionFont().draw(this.batch, "Stay alive. Find a way out of here.", Window.getWidth() / 2 - TextContainer.getLayout().width / 2, 600);
        }

        Game.getInstance().getPlayer().getInventory().draw(batch);


        batch.end();


//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        for (int i = 0; i < barManager.getNumbOfBars(); i++) {
//            shapeRenderer.setColor(barManager.getBarList().get(i).getEmptyColor());
//            shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getMaxLength(), barManager.getBarList().get(i).getHight());
//            shapeRenderer.setColor(barManager.getBarList().get(i).getColor());
//            shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getLength(), barManager.getBarList().get(i).getHight());
//        }
//        shapeRenderer.end();
    }

}
