package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.window.Window;

public class MaskedCircle {

    Pixmap resultedPixmap;
    Texture texture;
    Batch batch;

    Sprite sprite;

    float time = 0;

    public void init(Batch batch){

        this.batch = batch;

        Pixmap pixmap = new Pixmap(Window.getWidth()*3, Window.getHeight()*3, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();

        Pixmap mask = new Pixmap(Window.getWidth()*3, Window.getHeight()*3, Pixmap.Format.RGBA8888);
        mask.setColor(Color.BLACK);
        mask.fillCircle(Window.getWidth()*3/2, Window.getHeight()*3/2, 300);

        resultedPixmap = createMask(pixmap, mask);
        texture = new Texture(resultedPixmap);
        pixmap.dispose();

        sprite = new Sprite(texture, 0, 0, texture.getWidth(), texture.getHeight());

    }

    public void draw(){

        float newWidth = texture.getWidth() - time*300*0.64f;
        float newHeight = texture.getHeight() - time*300*0.36f;

        this.batch.draw(texture,
                GameController.getInstance().getPlayer().getSpriteCenter().x - newWidth/2,
                GameController.getInstance().getPlayer().getSpriteCenter().y - newHeight/2,
                newWidth,
                newHeight
                );

//        sprite.setSize(texture.getWidth() - time*100, texture.getHeight() - time*100);

        time+= Gdx.graphics.getDeltaTime();
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
                if(mask.getPixel(x, y) == 255){
                    System.out.println();
                }
            }
        }
        pixmap.setBlending(blending);

        return result;
    }

    public Pixmap createMask(Pixmap pixmap, Pixmap mask){
        int pixmapWidth = pixmap.getWidth();
        int pixmapHeight = pixmap.getHeight();

//        Pixmap result = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), pixmap.getFormat());
        Pixmap.Blending blending = pixmap.getBlending();
        pixmap.setBlending(Pixmap.Blending.None);

        for (int x=0; x<pixmapWidth; x++){
            for (int y=0; y<pixmapHeight; y++){
                if(mask.getPixel(x, y) == 255){
                    pixmap.setColor(0, 0, 0, 0);
                    pixmap.drawPixel(x, y );
                }
                if(mask.getPixel(x, y) == 255){
                    System.out.println();
                }
            }
        }

        pixmap.setBlending(blending);
        return pixmap;
    }

}
