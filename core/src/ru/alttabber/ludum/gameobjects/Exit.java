package ru.alttabber.ludum.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.ExitState;
import ru.alttabber.ludum.memory.Game;
import ru.alttabber.ludum.scene.CongratulationScene;
import ru.alttabber.ludum.scene.GameOverScene;
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

        this.textureOpen = Game.getInstance().getAssetManager().get(Assets.floorExitOpen);
        this.textureClosed = Game.getInstance().getAssetManager().get(Assets.floorExitClosed);

        this.spriteOpen = createScaledSprite(this.textureOpen);
        this.spriteClosed = createScaledSprite(this.textureClosed);

    }

    @Override
    public void draw() {
        super.draw();
        if(Game.getInstance().getExitState() == ExitState.EXIT_OPEN){
            this.spriteOpen.setPosition(XY.x, XY.y);
            this.spriteOpen.draw(batch);
        }else{
            this.spriteClosed.setPosition(XY.x, XY.y);
            this.spriteClosed.draw(batch);
        }
    }

    @Override
    public void doMapAction() {
        if(Game.getInstance().getExitState() == ExitState.EXIT_OPEN) {
            CongratulationScene level = (CongratulationScene) Game.getInstance().getLevelController().chooseLevel(CongratulationScene.class);
            level.init(batch);
            Player player = Game.getInstance().getPlayer();
            Game.getInstance().getPlayer().setXY(Window.getWidth() - player.width, player.XY.y);
        }else{
            Game.getInstance().getPlayer().showInstruction("Closed");
        }
    }


}
