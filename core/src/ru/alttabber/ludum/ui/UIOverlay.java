package ru.alttabber.ludum.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import ru.alttabber.ludum.gameobjects.GameObject;
import ru.alttabber.ludum.gameobjects.bars.BarManager;
import ru.alttabber.ludum.gameobjects.bars.HitBar;
import ru.alttabber.ludum.memory.GameController;

public class UIOverlay{

    BarManager barManager;
    ShapeRenderer shapeRenderer;

    public void init() {
        barManager = new BarManager();
        barManager.addNewBar(new HitBar(GameController.getInstance().getPlayer().getHits()));
        //barManager.addNewBar(new ManaBar());
        shapeRenderer = new ShapeRenderer();
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < barManager.getNumbOfBars(); i++) {
            shapeRenderer.setColor(barManager.getBarList().get(i).getEmptyColor());
            shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getMaxLength(), barManager.getBarList().get(i).getHight());
            shapeRenderer.setColor(barManager.getBarList().get(i).getColor());
            shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getLength(), barManager.getBarList().get(i).getHight());
        }
        shapeRenderer.end();
    }

}
