package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import ru.alttabber.ludum.gameobjects.models.WallModel;

public class Wall extends GameObject {

    private Rectangle rectangle;

    private float width;
    private float height;

    private Texture texture;
    private Sprite sprite;

    public Wall(Vector2 XY, Vector2 XY2) {
        this(XY.x, XY.y, XY2.x, XY2.y);
    }

    public Wall(float x1, float y1, float x2, float y2) {
        this.XY = new Vector2(x1, y1);
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
        rectangle = new Rectangle(x1, y1, this.width, this.height);
    }

    @Override
    public void draw() {
        if(sprite != null){
            batch.draw(sprite, XY.x, XY.y, width, height);
        }else{
            batch.draw(texture, XY.x, XY.y, width, height);
        }

    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;

        texture = WallModel.getInstance().getTexture();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setWallTexture(){
        texture = WallModel.getInstance().getWallTexture();
        sprite = createScaledSprite(texture);
    }

}
