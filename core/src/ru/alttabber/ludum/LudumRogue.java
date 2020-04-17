package ru.alttabber.ludum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import ru.alttabber.ludum.gameobjects.bars.BarManager;
import ru.alttabber.ludum.gameobjects.bars.HitBar;
import ru.alttabber.ludum.gameobjects.bars.ManaBar;
import ru.alttabber.ludum.gameobjects.items.SwordItem;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.scene.StartScene;
import ru.alttabber.ludum.utils.SpriteAnimation;

public class LudumRogue extends ApplicationAdapter {

	SpriteBatch batch;
	StartScene startScene;

	BarManager barManager;
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		startScene = new StartScene();
		startScene.init(batch);

		barManager = new BarManager();
		barManager.addNewBar(new HitBar(GameController.getInstance().getPlayer().getHits()));
		barManager.addNewBar(new ManaBar());
		shapeRenderer = new ShapeRenderer();

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		startScene.draw();
		batch.end();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (int i = 0; i < barManager.getNumbOfBars(); i++) {
			shapeRenderer.setColor(barManager.getBarList().get(i).getEmptyColor());
			shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getMaxLength(), barManager.getBarList().get(i).getHight());
			shapeRenderer.setColor(barManager.getBarList().get(i).getColor());
			shapeRenderer.rect(barManager.getStartX(), barManager.getYOfBar(i), barManager.getBarList().get(i).getLength(), barManager.getBarList().get(i).getHight());
		}
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
