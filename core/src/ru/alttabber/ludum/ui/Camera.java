package ru.alttabber.ludum.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.window.Window;

public class Camera {

    OrthographicCamera camera;

    public void init(){

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Window.getWidth(), Window.getHeight());
//        camera.rotate(180);
        camera.update();

    }

    public void update(){
        camera.position.set(Game.getInstance().getPlayer().getSpriteCenter().x, Game.getInstance().getPlayer().getSpriteCenter().y, 0);
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
