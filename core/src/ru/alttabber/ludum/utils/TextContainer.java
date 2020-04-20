package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextContainer {

    private static BitmapFont buttonPrimaryFont;
    private static BitmapFont labelHeaderFont;
    private static BitmapFont instructionFont;
    private static GlyphLayout layout = new GlyphLayout();


    public static BitmapFont getHeaderLabelFont() {
        if (labelHeaderFont == null) {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/YesevaOne-Regular.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 50;
            parameter.borderWidth = 4;
            parameter.borderStraight = true;
            parameter.borderColor = new Color(182/255f, 77/255f, 77/255f, 1);
            parameter.spaceX = -2;
            parameter.color = new Color(0, 0, 0, 1);
            labelHeaderFont = generator.generateFont(parameter);
        }
        return labelHeaderFont;
    }

    public static BitmapFont getInstructionFont() {
        if (instructionFont == null) {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Manrope-Light.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 20;
//            parameter.borderWidth = 4;
//            parameter.borderStraight = true;
//            parameter.borderColor = new Color(182/255f, 77/255f, 77/255f, 1);
//            parameter.spaceX = -2;
            parameter.color = new Color(200/255f, 200/255f, 200/255f, 1);
            instructionFont = generator.generateFont(parameter);
        }
        return instructionFont;
    }

    public static GlyphLayout getLayout() {
        return layout;
    }
}
