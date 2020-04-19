package ru.alttabber.ludum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.scene.StartScene;
import ru.alttabber.ludum.ui.UIOverlay;
import ru.alttabber.ludum.utils.MaskedCircle;

public class LudumRogue extends ApplicationAdapter {

	SpriteBatch batch;
	StartScene startScene;

	UIOverlay ui;

	MaskedCircle maskedCircle;

	@Override
	public void create () {
		batch = new SpriteBatch();

		startScene = (StartScene) GameController.getInstance().getLevelController().chooseLevel(StartScene.class);
		startScene.init(batch);

		this.ui = new UIOverlay();
		this.ui.init();

		maskedCircle = new MaskedCircle();
		maskedCircle.init(batch);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(50/255f, 50/255f, 50/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		GameController.getInstance().getLevelController().getCurrentLevel().draw();
		maskedCircle.draw();
		batch.end();

		this.ui.draw();

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
