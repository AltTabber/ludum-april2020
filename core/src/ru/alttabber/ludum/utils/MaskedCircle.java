package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.window.Window;

public class MaskedCircle {

    Pixmap resultedPixmap;
    Texture texture;
    Texture blackRectangle;
    Batch batch;

    Sprite sprite;
    Sprite blackRectangleSprite;

    int size = 1000;
    int maxSize = 1000;

    float width;
    float height;
    float deltaWidth = 0;
    float deltaHeight = 0;
    float maxWidth;
    float minWidth;

    float maxHeight;
    float minHeight;

    float alpha = 1;

    public void init(Batch batch){

        this.batch = batch;

        Pixmap pixmap = new Pixmap(Window.getWidth()*4, Window.getHeight()*4, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();

        Pixmap mask = new Pixmap(Window.getWidth()*4, Window.getHeight()*4, Pixmap.Format.RGBA8888);
        mask.setColor(Color.BLACK);
        mask.fillCircle(Window.getWidth()*4/2, Window.getHeight()*4/2, 300);

        resultedPixmap = createMask(pixmap, mask);
        texture = new Texture(resultedPixmap);
        pixmap.dispose();
        mask.dispose();

        sprite = new Sprite(texture, 0, 0, texture.getWidth(), texture.getHeight());

        maxWidth = Window.getWidth()*6;
        minWidth = Window.getWidth()*6/5;
        maxHeight = Window.getHeight()*6;
        minHeight = Window.getHeight()*6/5;
        deltaWidth = (maxWidth - minWidth)/maxSize;
        deltaHeight = (maxHeight - minHeight)/maxSize;

        pixmap = new Pixmap(Window.getWidth(), Window.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        blackRectangle = new Texture(pixmap);
        pixmap.dispose();

        blackRectangleSprite = new Sprite(texture, 0, 0, Window.getWidth(), Window.getHeight());


        changeMaskedCircle(size);

    }

    public void draw(){

        changeMaskedCircle((int) ((Game.getInstance().getPlayer().getLampHp()/100f) * maxSize));
        sprite.setAlpha(alpha);
        sprite.setX(Game.getInstance().getPlayer().getSpriteCenter().x - this.width/2);
        sprite.setY(Game.getInstance().getPlayer().getSpriteCenter().y - this.height/2);
        sprite.setSize(this.width, this.height);
        sprite.draw(batch);

        blackRectangleSprite.setX(Game.getInstance().getPlayer().getSpriteCenter().x - this.blackRectangle.getWidth()/2);
        blackRectangleSprite.setY(Game.getInstance().getPlayer().getSpriteCenter().y - this.blackRectangle.getHeight()/2);
        blackRectangleSprite.setAlpha((100 - Game.getInstance().getPlayer().getHp())/100);
        blackRectangleSprite.draw(batch);

        this.alpha += Gdx.graphics.getDeltaTime()/3;
        setAlpha(this.alpha);

//        this.batch.draw(sprite,
//                ,
//                Game.getInstance().getPlayer().getSpriteCenter().y - this.height/2,
//                this.width,
//                this.height
//                );
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        if(this.alpha < 0) this.alpha = 0;
        if(this.alpha > 1) this.alpha = 1;
    }

    // size - 0-1000;
    public void changeMaskedCircle(int size){
        if(size < 0)
            throw new RuntimeException("Size of circle more than 1000 or less than 0");

        this.size = size;
        this.width = maxWidth - (maxSize-size) * deltaWidth;
        this.height = maxHeight - (maxSize-size) * deltaHeight;
    }

    public Pixmap pixmapMask(Pixmap pixmap, Pixmap mask, boolean invertMaskAlpha){
        int pixmapWidth = pixmap.getWidth();
        int pixmapHeight = pixmap.getHeight();
        Color pixelColor = new Color();
        Color maskPixelColor = new Color();

        Pixmap result = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), pixmap.getFormat());

        Pixmap.Blending blending = pixmap.getBlending();
        pixmap.setBlending(Pixmap.Blending.None);
        for (int x=0; x<pixmapWidth; x++){
            for (int y=0; y<pixmapHeight; y++){
                Color.rgba8888ToColor(pixelColor, pixmap.getPixel(x, y));                           // get pixel color
                Color.rgba8888ToColor(maskPixelColor, mask.getPixel(x, y));                         // get mask color


                maskPixelColor.a = (invertMaskAlpha) ? 1.0f-maskPixelColor.a : maskPixelColor.a;    // IF invert mask
                pixelColor.a = pixelColor.a * maskPixelColor.a;                                     // multiply pixel alpha * mask alpha
                result.setColor(pixelColor);
                result.drawPixel(x, y);
            }
        }
        pixmap.setBlending(blending);

        return result;
    }

    public Pixmap createMask(Pixmap pixmap, Pixmap mask){
        int pixmapWidth = pixmap.getWidth();
        int pixmapHeight = pixmap.getHeight();

        Pixmap.Blending blending = pixmap.getBlending();
        pixmap.setBlending(Pixmap.Blending.None);
        for (int x=0; x<pixmapWidth; x++){
            for (int y=0; y<pixmapHeight; y++){
                if(mask.getPixel(x, y) == 255){
                    pixmap.setColor(0, 0, 0, 0);
                    pixmap.drawPixel(x, y );
                }
            }
        }
        pixmap.setBlending(blending);
        return pixmap;
    }

}
