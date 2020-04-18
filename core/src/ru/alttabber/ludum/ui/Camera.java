package ru.alttabber.ludum.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import ru.alttabber.ludum.memory.GameController;
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
        camera.position.set(GameController.getInstance().getPlayer().getSpriteCenter().x, GameController.getInstance().getPlayer().getSpriteCenter().y, 0);
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
