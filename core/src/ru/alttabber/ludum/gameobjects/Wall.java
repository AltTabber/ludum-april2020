package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall extends GameObject {

    private Rectangle rectangle;

    private float width;
    private float height;

    private Texture texture;

    public Wall(Vector2 XY, Vector2 XY2) {
        rectangle = new Rectangle(XY.x, XY.y, Math.abs(XY.x - XY2.x), Math.abs(XY.y - XY2.y));
        this.XY = new Vector2(XY.x, XY.y);
        this.width = Math.abs(XY.x - XY2.x);
        this.height = Math.abs(XY.y - XY2.y);
    }

    @Override
    public void draw() {
        batch.draw(texture, XY.x, XY.y, width, height);
    }

    @Override
    public void init(Batch batch) {
        this.batch = batch;

        Pixmap pixmap = new Pixmap((int) this.width, (int) this.height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CYAN);
        pixmap.fillRectangle(0, 0, (int) width, (int) height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
