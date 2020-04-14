package ru.alttabber.ludum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.alttabber.ludum.items.SwordItem;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.units.Player;

public class LudumRogue extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;

	Player player;
	SwordItem item;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		GameController.getInstance().getAssetController().loadPlayerAssets();
		GameController.getInstance().getAssetController().loadItems();
		GameController.getInstance().getAssetManager().finishLoading();

		player = new Player();
		player.init(batch);

		GameController.getInstance().setPlayer(player);

		item = new SwordItem();
		item.init(batch);
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		item.draw();
		player.draw();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
