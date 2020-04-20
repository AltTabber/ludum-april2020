package ru.alttabber.ludum.gameobjects.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

public class WallModel {

    private Texture texture;
    private Texture wallTexture;

    public static WallModel instance;

    private WallModel() {
        Pixmap pixmap = new Pixmap(250, 250, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillRectangle(0, 0, 250, 250);
        texture = new Texture(pixmap);
        pixmap.dispose();

        wallTexture = Game.getInstance().getAssetManager().get(Assets.wall, Texture.class);
    }

    public static WallModel getInstance(){
        if(instance == null){
            instance = new WallModel();
        }
        return instance;
    }

    public Texture getTexture() {
        return texture;
    }

    public Texture getWallTexture() {
        return wallTexture;
    }

}
