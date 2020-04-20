package ru.alttabber.ludum.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.Exit;
import ru.alttabber.ludum.gameobjects.GameObject;
import ru.alttabber.ludum.gameobjects.items.KeyItem;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

public class CompassUI extends GameObject {

    Texture arrowKeyTexture;
    Texture arrowExitTexture;

    Sprite arrowKey;
    Sprite arrowExit;

    Vector2 directionKey;
    Vector2 directionExit;

    float radius = 200;
    float alpha = 0f;
    float alphaSpeed = 0.05f;

    @Override
    public void init(Batch batch) {
        this.batch = batch;

        arrowKeyTexture = Game.getInstance().getAssetManager().get(Assets.arrowKey, Texture.class);
        arrowExitTexture = Game.getInstance().getAssetManager().get(Assets.arrowExit, Texture.class);

        this.width = 60;
        this.height = 60;

        arrowKey = createScaledSprite(arrowKeyTexture);
        arrowExit = createScaledSprite(arrowExitTexture);
        directionKey = new Vector2();
        directionExit = new Vector2();


    }


    @Override
    public void draw() {

        setAlpha(alpha - Gdx.graphics.getDeltaTime() * alphaSpeed);
        Vector2 key = Game.getInstance().getCollisionController().getUsableObjectByClass(KeyItem.class);

        if (key != null) {
            directionKey = Game.getInstance().getPlayer().getSpriteCenter()
                    .sub(key)
                    .nor().rotate90(1).rotate90(1);
            arrowKey.setPosition(Game.getInstance().getPlayer().getSpriteCenter().x + directionKey.x * radius,
                    Game.getInstance().getPlayer().getSpriteCenter().y + directionKey.y * radius);
            arrowKey.setOrigin(arrowKey.getWidth() / 2, arrowKey.getHeight() / 2);
            arrowKey.setRotation(directionKey.angle());
            arrowKey.draw(batch, alpha);
        }


        Vector2 exit = Game.getInstance().getCollisionController().getAutoUsableObjectByClass(Exit.class);
        if (exit != null) {
            directionExit = Game.getInstance().getPlayer().getSpriteCenter()
                    .sub(exit)
                    .nor().rotate90(1).rotate90(1);
            arrowExit.setPosition(Game.getInstance().getPlayer().getSpriteCenter().x + directionExit.x * radius,
                    Game.getInstance().getPlayer().getSpriteCenter().y + directionExit.y * radius);
            arrowExit.setOrigin(arrowExit.getWidth() / 2, arrowExit.getHeight() / 2);
            arrowExit.setRotation(directionExit.angle());
            arrowExit.draw(batch, alpha);
        }

    }

    public void setAlpha(float alpha){
        this.alpha = alpha;
        if(this.alpha < 0)
            this.alpha = 0;

        if(this.alpha > 0.5f)
            this.alpha = 0.5f;
    }

}
