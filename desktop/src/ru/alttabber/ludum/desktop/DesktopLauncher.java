package ru.alttabber.ludum.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.alttabber.ludum.LudumRogue;
import ru.alttabber.ludum.window.Window;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Window.getTitle();
		config.width = Window.getWidth();
		config.height = Window.getHeight();
		new LwjglApplication(new LudumRogue(), config);
	}
}
