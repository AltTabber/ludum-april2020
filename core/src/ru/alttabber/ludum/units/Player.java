package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.memory.GameController;

public class Player extends Unit {

    Texture behindTexture;
    Texture frontTexture;
    Texture sideTexture;
    Texture sideFrontTexture;
    Texture sideBehindTexture;
    Texture currentTexture;

    public Player() {
        super();
        this.height = 100;
        this.width = 100;
    }

    @Override
    public void init(Batch batch) {
        GameController.getInstance().getAssetController().loadPlayerAsset();

        behindTexture = GameController.getInstance().getAssetManager().get("behind.png");
        frontTexture = GameController.getInstance().getAssetManager().get("front.png");
        sideTexture = GameController.getInstance().getAssetManager().get("12.png");
        sideFrontTexture = GameController.getInstance().getAssetManager().get("34front.png");
        sideBehindTexture = GameController.getInstance().getAssetManager().get("34behind.png");
        currentTexture = frontTexture;


    }


}
