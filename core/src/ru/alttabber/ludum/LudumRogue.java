package ru.alttabber.ludum;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
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
import ru.alttabber.ludum.ui.UIOverlay;
import ru.alttabber.ludum.utils.SpriteAnimation;

public class LudumRogue extends ApplicationAdapter {

	SpriteBatch batch;
	StartScene startScene;

	UIOverlay ui;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		startScene = (StartScene) GameController.getInstance().getLevelController().chooseLevel(StartScene.class);
		startScene.init(batch);

		this.ui = new UIOverlay();
		this.ui.init();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(50/255f, 50/255f, 50/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		GameController.getInstance().getLevelController().getCurrentLevel().draw();
		batch.end();

		this.ui.draw();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
