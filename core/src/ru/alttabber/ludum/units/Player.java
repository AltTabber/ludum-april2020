package ru.alttabber.ludum.units;

import com.badlogic.gdx.Gdx;
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
    Sprite upLeftSprite;
    Sprite upRightSprite;
    Sprite downLeftSprite;
    Sprite downRightSprite;

    Sprite sprite;

    PlayerInput input = PlayerInput.IDLE;

    int counter = 0;
    
    int speed = 300;

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

        this.upRightSprite = createScaledSprite(sideBehindTexture);
        this.upLeftSprite = createScaledSprite(sideBehindTexture);
        this.upLeftSprite.flip(true, false);
        this.downRightSprite = createScaledSprite(sideFrontTexture);
        this.downLeftSprite = createScaledSprite(sideFrontTexture);
        this.downLeftSprite.flip(true, false);


        this.sprite = this.downSprite;

        this.batch = batch;
    }

    @Override
    public void draw() {
        this.sprite.draw(batch);
        this.input = GameController.getInstance().getInputController().getCurrentPlayerInput();
        this.doActionByInput(this.input);
        this.input = PlayerInput.IDLE;
        sprite.setPosition(this.x, this.y);
    }

    public void doActionByInput(PlayerInput input){
        switch (input) {
            case UP:
                sprite = this.upSprite;
                this.y = this.y + speed * Gdx.graphics.getDeltaTime();
                break;
            case DOWN:
                sprite = this.downSprite;
                this.y = this.y - speed * Gdx.graphics.getDeltaTime();
                break;
            case RIGHT:
                sprite = this.rightSprite;
                this.x = this.x + speed * Gdx.graphics.getDeltaTime();
                break;
            case LEFT:
                sprite = this.leftSprite;
                this.x = this.x - speed * Gdx.graphics.getDeltaTime();
                break;
            case UPLEFT:
                sprite = this.upLeftSprite;
                this.x = this.x - speed * Gdx.graphics.getDeltaTime();
                this.y = this.y + speed * Gdx.graphics.getDeltaTime();
                break;
            case UPRIGHT:
                sprite = this.upRightSprite;
                this.x = this.x + speed * Gdx.graphics.getDeltaTime();
                this.y = this.y + speed * Gdx.graphics.getDeltaTime();
                break;
            case DOWNLEFT:
                sprite = this.downLeftSprite;
                this.x = this.x - speed * Gdx.graphics.getDeltaTime();
                this.y = this.y - speed * Gdx.graphics.getDeltaTime();
                break;
            case DOWNRIGHT:
                sprite = this.downRightSprite;
                this.x = this.x + speed * Gdx.graphics.getDeltaTime();
                this.y = this.y - speed * Gdx.graphics.getDeltaTime();
                break;
            case IDLE:
                break;
        }
    }


}
