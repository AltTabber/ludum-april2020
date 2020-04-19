package ru.alttabber.ludum.gameobjects.models;

import com.badlogic.gdx.graphics.Texture;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class FlareGunModel {

    private Texture texture;

    public static FlareGunModel instance;

    private FlareGunModel() {
        this.texture = GameController.getInstance().getAssetManager().get(Assets.flareGunTexture, Texture.class);
    }

    public static FlareGunModel getInstance(){
        if(instance == null){
            instance = new FlareGunModel();
        }
        return instance;
    }

    public Texture getTexture() {
        return texture;
    }

}
