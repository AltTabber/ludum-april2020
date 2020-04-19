package ru.alttabber.ludum.gameobjects.models;

import com.badlogic.gdx.graphics.Texture;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class KeyModel {

    private Texture texture;

    public static KeyModel instance;

    private KeyModel() {
        this.texture = GameController.getInstance().getAssetManager().get(Assets.keyTexture, Texture.class);
    }

    public static KeyModel getInstance(){
        if(instance == null){
            instance = new KeyModel();
        }
        return instance;
    }

    public Texture getTexture() {
        return texture;
    }
}
