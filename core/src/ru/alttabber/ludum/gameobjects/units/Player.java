package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.AutomaticUsableObject;
import ru.alttabber.ludum.gameobjects.items.Item;
import ru.alttabber.ludum.inputs.PlayerInput;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.ui.Inventory;
import ru.alttabber.ludum.utils.SpriteAnimation;

public class Player extends Unit {

    private SpriteAnimation upAnimation;
    private SpriteAnimation downAnimation;
    private SpriteAnimation rightAnimation;
    private SpriteAnimation leftAnimation;
    private SpriteAnimation upRightAnimation;
    private SpriteAnimation upLeftAnimation;
    private SpriteAnimation downRightAnimation;
    private SpriteAnimation downLeftAnimation;
    private SpriteAnimation currentAnimation;
    private float animationTime = 0;

    private Vector2 nextXY;

    private Sound footStep;

    private Sprite sprite;

    private PlayerInput input = PlayerInput.IDLE;

    private Inventory inventory;

    private Circle collisionCircle;

    private Vector2 movementVector;
    private float lampHp;
    private float lampHpDrain;

    float footStepTime = 1f;
    boolean nowGo = false;

    int counter = 0;
    
    int speed = 300;

    public Player() {
        super();
        this.height = 180;
        this.width = 180;
        this.hits = 100;

    }

    @Override
    public void init(Batch batch) {
        footStep = GameController.getInstance().getAssetManager().get(Assets.footStep);

        this.XY.x = 400;
        this.XY.y = 400;

        this.nextXY = new Vector2(XY.x, XY.y);

        this.upAnimation = new SpriteAnimation(Assets.frontTextureAnimation, this.width, this.height);
        this.downAnimation = new SpriteAnimation(Assets.behindTextureAnimation, this.width, this.height);
        this.rightAnimation = new SpriteAnimation(Assets.rightTextureAnimation, this.width, this.height);
        this.upRightAnimation = new SpriteAnimation(Assets.downRightTextureAnimation, this.width, this.height);
        this.downRightAnimation = new SpriteAnimation(Assets.upRightTextureAnimation, this.width, this.height);

        this.leftAnimation = new SpriteAnimation(Assets.leftTextureAnimation, this.width, this.height);
        this.upLeftAnimation = new SpriteAnimation(Assets.downLeftTextureAnimation, this.width, this.height);
        this.downLeftAnimation = new SpriteAnimation(Assets.upLeftTextureAnimation, this.width, this.height);

        this.lampHp = 100;
        this.lampHpDrain = 2;

//        this.leftAnimation = new SpriteAnimation(Assets.rightTextureAnimation, this.width, this.height);
//        this.leftAnimation.transformSprites(animationSprite -> {
//            animationSprite.flip(true,false);
//        });
//        this.upLeftAnimation = new SpriteAnimation(Assets.downRightTextureAnimation, this.width, this.height);
//        this.upLeftAnimation.transformSprites(animationSprite -> {
//            animationSprite.flip(true,false);
//        });
//        this.downLeftAnimation = new SpriteAnimation(Assets.upRightTextureAnimation, this.width, this.height);
//        this.downLeftAnimation.transformSprites(animationSprite -> {
//            animationSprite.flip(true,false);
//        });

        this.currentAnimation = this.downAnimation;

        Sprite[] frames =  this.currentAnimation.getAnimation().getKeyFrames();
        this.sprite = frames[frames.length - 1];

        this.collisionCircle = new Circle();
        refreshCollisionRect();

        this.movementVector = new Vector2();

        this.inventory = new Inventory();

        this.batch = batch;
    }

    @Override
    public void draw() {
        this.input = GameController.getInstance().getInputController().getCurrentPlayerInput();
        this.doActionByInput(this.input);
        refreshCollisionRect();
        float deltaTime = Gdx.graphics.getDeltaTime();
        nextXY.x = this.XY.x + speed * deltaTime* this.movementVector.x;
        nextXY.y = this.XY.y + speed * deltaTime * this.movementVector.y;
        if(GameController.getInstance().getCollisionController().isMovementPossible(getCollisionCircleByCoord(nextXY))){
            this.XY.x = this.nextXY.x;
            this.XY.y = this.nextXY.y;
        }
        AutomaticUsableObject autoUseObj =
                GameController.getInstance().getCollisionController().getAutoUseObject(this.collisionCircle);
        if(autoUseObj != null){
            autoUseObj.doMapAction();
        }
        sprite.setPosition(this.XY.x, this.XY.y);
        this.sprite.draw(batch);

        this.input = PlayerInput.IDLE;
        this.addHp(-this.lampHpDrain * deltaTime);

    }

    public void doActionByInput(PlayerInput input){
        this.animationTime += Gdx.graphics.getDeltaTime();
        switch (input) {
            case UP:
                this.currentAnimation = this.downAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = 1;
                this.movementVector.x = 0;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case DOWN:
                this.currentAnimation = this.upAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = -1;
                this.movementVector.x = 0;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case RIGHT:
                this.currentAnimation = this.rightAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = 0;
                this.movementVector.x = 1;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case LEFT:
                this.currentAnimation = this.leftAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = 0;
                this.movementVector.x = -1;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case UPLEFT:
                this.currentAnimation = this.upLeftAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = 0.7f;
                this.movementVector.x = -0.7f;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case UPRIGHT:
                this.currentAnimation = this.upRightAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = 0.7f;
                this.movementVector.x = 0.7f;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case DOWNLEFT:
                this.currentAnimation = this.downLeftAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = -0.7f;
                this.movementVector.x = -0.7f;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case DOWNRIGHT:
                this.currentAnimation = this.downRightAnimation;
                this.sprite = this.currentAnimation.getKeyFrame(animationTime);
                this.movementVector.y = -0.7f;
                this.movementVector.x = 0.7f;
                footStepTime = footStepTime + Gdx.graphics.getDeltaTime();
                nowGo = true;
                break;
            case IDLE:
                animationTime = 0;
                Sprite[] frames =  this.currentAnimation.getAnimation().getKeyFrames();
                this.movementVector.y = 0;
                this.movementVector.x = 0;
                this.sprite = frames[frames.length - 1];
                footStepTime = 1f;
                nowGo = false;
                break;
        }
        if((footStepTime > 0.4f)&&(nowGo))
        {
            footStep.play();
            footStepTime = 0f;
        }
    }

    public void makeFootStepSound(){
        footStep.play();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Circle getCollisionCircle() {
        return collisionCircle;
    }

    private void refreshCollisionRect(){
        this.refreshCollisionRect(this.collisionCircle, this.XY);
    }

    private void refreshCollisionRect(Circle circle, Vector2 XY){
        circle.x = XY.x + this.width/2;
        circle.y = XY.y + this.height/8;
        circle.radius = this.width/8;
    }

    public Circle getCollisionCircleByCoord(Vector2 XY){
        Circle circle = new Circle();
        refreshCollisionRect(circle, XY);
        return circle;
    }

    public void useItem() {
        Item item = GameController.getInstance().getCollisionController().getUsableObject(collisionCircle);
        if(item != null) {
            item.doMapAction();
        }
    }

    public void setXY(float x, float y) {
        this.XY.x = x;
        this.XY.y = y;
    }

    public void teleport(float x, float y) {
        this.XY.x = x - width/2;
        this.XY.y = y - height/2;
        this.nextXY.x = XY.x;
        this.nextXY.y = XY.y;
        refreshCollisionRect();
    }

    public float getLampHp() {
        return lampHp;
    }

    public void setLampHp(float lampHp) {
        this.lampHp = lampHp;
    }

    public void addHp(float delta){
        this.lampHp += delta;
        if(this.lampHp < 0)
            this.lampHp = 0;
        if(this.lampHp > 100)
            this.lampHp = 100;
    }
}
