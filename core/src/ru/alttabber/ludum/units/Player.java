package ru.alttabber.ludum.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.inputs.PlayerInput;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;

public class Player extends Unit {

    Texture behindTexture;
    Texture frontTexture;
    Texture sideTexture;
    Texture sideFrontTexture;
    Texture sideBehindTexture;
    Texture currentTexture;

    Sprite leftSprite;
    Sprite rightSprite;
    Sprite upSprite;
    Sprite downSprite;

    Sprite sprite;

    PlayerInput input = PlayerInput.IDLE;

    int counter = 0;

    public Player() {
        super();
        this.height = 200;
        this.width = 200;
    }

    @Override
    public void init(Batch batch) {
        behindTexture = GameController.getInstance().getAssetManager().get(Assets.behindTexture);
        frontTexture = GameController.getInstance().getAssetManager().get(Assets.frontTexture);
        sideTexture = GameController.getInstance().getAssetManager().get(Assets.sideTexture);
        sideFrontTexture = GameController.getInstance().getAssetManager().get(Assets.sideFrontTexture);
        sideBehindTexture = GameController.getInstance().getAssetManager().get(Assets.sideBehindTexture);
        currentTexture = frontTexture;

        this.x = 0;
        this.y = 0;

        this.leftSprite = createScaledSprite(sideTexture);
        this.leftSprite.flip(true, false);
        this.rightSprite = createScaledSprite(sideTexture);
        this.upSprite = createScaledSprite(behindTexture);
        this.downSprite = createScaledSprite(frontTexture);

        this.sprite = this.downSprite;

        this.batch = batch;
    }

    @Override
    public void draw() {
        sprite.setPosition(this.x, this.y);
        this.sprite.draw(batch);
        this.input = GameController.getInstance().getInputController().getCurrentPlayerInput();
        this.changeTextureByInput(this.input);
        this.input = PlayerInput.IDLE;
    }

    public void changeTextureByInput(PlayerInput input){
        switch (input) {
            case UP:
                sprite = this.upSprite;
                break;
            case DOWN:
                sprite = this.downSprite;
                break;
            case RIGHT:
                sprite = this.rightSprite;
                break;
            case LEFT:
                sprite = this.leftSprite;
                break;
        }
    }


}
