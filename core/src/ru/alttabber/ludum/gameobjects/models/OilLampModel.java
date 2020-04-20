package ru.alttabber.ludum.gameobjects.models;

import com.badlogic.gdx.graphics.Texture;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

public class OilLampModel {

    private Texture texture;

    public static OilLampModel instance;

    private OilLampModel() {
        this.texture = Game.getInstance().getAssetManager().get(Assets.oilTexture, Texture.class);
    }

    public static OilLampModel getInstance(){
        if(instance == null){
            instance = new OilLampModel();
        }
        return instance;
    }

    public Texture getTexture() {
        return texture;
    }
}
