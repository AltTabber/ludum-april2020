package ru.alttabber.ludum.gameobjects.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

public class Ghost extends Unit {

    Texture texture;
    Texture textureOverlay;
    Sprite sprite;
    Sprite spriteOverlay;

    float hitboxRadius;
    Vector2 hitboxCenter;
    Circle hitbox;

    float speed;
    float minSpeed = 50;

    @Override
    public void init(Batch batch) {

        this.batch = batch;

        this.XY.x = 800;
        this.XY.y = 200;

        this.width = 200;
        this.height = 200;

        this.texture = Game.getInstance().getAssetManager().get(Assets.ghostTexture);
        this.sprite = createScaledSprite(texture);

        this.textureOverlay = Game.getInstance().getAssetManager().get(Assets.ghostOverlayTexture);
        this.spriteOverlay = createScaledSprite(textureOverlay);



        this.speed = minSpeed;

        this.hitboxCenter = new Vector2(XY.x + this.width/2, XY.y + this.height/2);
        this.hitboxRadius = 60;
        this.hitbox = new Circle(hitboxCenter, hitboxRadius);


    }

    @Override
    public void draw() {
        Vector2 movementTarget = Game.getInstance().getPlayer().getSpriteCenter();

        Vector2 velocityVector = this.getSpriteCenter().sub(movementTarget).nor();

        this.XY.add(-1 * velocityVector.x * this.speed * Gdx.graphics.getDeltaTime(),
                -1 * velocityVector.y * this.speed * Gdx.graphics.getDeltaTime());

        this.sprite.setPosition(this.XY.x, this.XY.y);

        setHitBox();
        deltaSpeed();

        checkPlayerHover();

        this.sprite.draw(batch);

        System.out.println(speed + "  " + minSpeed);
    }

    private void checkPlayerHover() {
        Player player = Game.getInstance().getPlayer();
        Circle playerCircle = Game.getInstance().getPlayer().getCollisionCircle();
        if(this.hitbox.overlaps(playerCircle)){
            player.addHp(-100);
        }
    }

    public void drawOnOverlay() {
        this.spriteOverlay.setPosition(this.XY.x, this.XY.y);
        this.spriteOverlay.draw(batch);
    }

    public void deltaSpeed(){
        if(Game.getInstance().getPlayer().getLampHp() < 30) {
            this.speed += Gdx.graphics.getDeltaTime() * 10;
        } else {
            this.speed -= Gdx.graphics.getDeltaTime() * 10;
        }

        this.minSpeed += Gdx.graphics.getDeltaTime() ;

        if(this.speed<minSpeed) this.speed = minSpeed;

    }

    public void setHitBox(){
        this.hitboxCenter.set(XY.x + this.width/2, XY.y + this.height/2);
        this.hitbox.setPosition(this.hitboxCenter);
    }



}
