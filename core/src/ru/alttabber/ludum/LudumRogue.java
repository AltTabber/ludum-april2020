package ru.alttabber.ludum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.scene.StartScene;
import ru.alttabber.ludum.ui.UIOverlay;

public class LudumRogue extends ApplicationAdapter {

	SpriteBatch batch;
	StartScene startScene;

	UIOverlay ui;


	@Override
	public void create () {
		batch = new SpriteBatch();

		startScene = (StartScene) Game.getInstance().getLevelController().chooseLevel(StartScene.class);
		startScene.init(batch);

		this.ui = new UIOverlay();
		this.ui.init();


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(50/255f, 50/255f, 50/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		Game.getInstance().getLevelController().getCurrentLevel().draw();



		this.ui.draw();

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
