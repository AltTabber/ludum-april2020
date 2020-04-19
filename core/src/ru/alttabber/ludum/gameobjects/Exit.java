package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.ExitState;
import ru.alttabber.ludum.memory.GameController;
import ru.alttabber.ludum.scene.SecondScene;
import ru.alttabber.ludum.window.Window;

public class Exit extends AutomaticUsableObject {

    public Exit(float x, float y) {
        this.XY.x = x;
        this.XY.y = y;
    }

    private Texture textureOpen;
    private Texture textureClosed;

    private Sprite spriteOpen;
    private Sprite spriteClosed;

    @Override
    public void init(Batch batch) {
        super.init(batch);

        this.width = 150;
        this.height = 150;

        this.rect = new Rectangle(XY.x, XY.y, this.width, this.height);

        this.textureOpen = GameController.getInstance().getAssetManager().get(Assets.floorExitOpen);
        this.textureClosed = GameController.getInstance().getAssetManager().get(Assets.floorExitClosed);

        this.spriteOpen = createScaledSprite(this.textureOpen);
        this.spriteClosed = createScaledSprite(this.textureClosed);

    }

    @Override
    public void draw() {
        super.draw();
        if(GameController.getInstance().getExitState() == ExitState.EXIT_OPEN){
            this.spriteOpen.setPosition(XY.x, XY.y);
            this.spriteOpen.draw(batch);
        }else{
            this.spriteClosed.setPosition(XY.x, XY.y);
            this.spriteClosed.draw(batch);
        }
    }

    @Override
    public void doMapAction() {
        if(GameController.getInstance().getExitState() == ExitState.EXIT_OPEN) {
            SecondScene level = (SecondScene) GameController.getInstance().getLevelController().chooseLevel(SecondScene.class);
            level.init(batch);
            Player player = GameController.getInstance().getPlayer();
            GameController.getInstance().getPlayer().setXY(Window.getWidth() - player.width, player.XY.y);
        }else{
            //Сообщение
        }
    }


}
