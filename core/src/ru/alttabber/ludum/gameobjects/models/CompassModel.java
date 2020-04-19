package ru.alttabber.ludum.gameobjects.models;

import com.badlogic.gdx.graphics.Texture;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class CompassModel {

    private Texture texture;

    public static CompassModel instance;

    private CompassModel() {
        this.texture = GameController.getInstance().getAssetManager().get(Assets.compassTexture, Texture.class);
    }

    public static CompassModel getInstance(){
        if(instance == null){
            instance = new CompassModel();
        }
        return instance;
    }

    public Texture getTexture() {
        return texture;
    }

}
