package ru.alttabber.ludum.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.inputs.PlayerInput;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.ui.Inventory;

public class Player extends Unit {

    private Texture behindTexture;
    private Texture frontTexture;
    private Texture sideTexture;
    private Texture sideFrontTexture;
    private Texture sideBehindTexture;
    private Texture currentTexture;

    private Sprite leftSprite;
    private Sprite rightSprite;
    private Sprite upSprite;
    private Sprite downSprite;
    private Sprite upLeftSprite;
    private Sprite upRightSprite;
    private Sprite downLeftSprite;
    private Sprite downRightSprite;

    private Sprite sprite;

    private PlayerInput input = PlayerInput.IDLE;

    private Inventory inventory;

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

        this.x = 400;
        this.y = 400;

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
        this.input = GameController.getInstance().getInputController().getCurrentPlayerInput();
        this.doActionByInput(this.input);
        sprite.setPosition(this.x, this.y);
        this.sprite.draw(batch);

        this.input = PlayerInput.IDLE;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
