package ru.alttabber.ludum.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.Exit;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.items.CompassItem;
import ru.alttabber.ludum.gameobjects.items.FlareGunItem;
import ru.alttabber.ludum.gameobjects.items.KeyItem;
import ru.alttabber.ludum.gameobjects.items.OilLampItem;
import ru.alttabber.ludum.gameobjects.units.Ghost;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapController {

    float blockWidth = 150;
    float blockHeight = 150;

    List<Wall> walls;

    Batch batch;

    public void init(Batch batch){

        this.batch = batch;

        FileHandle handle = Gdx.files.internal("maps/map1.txt");

        String str = handle.readString();
        str = str.replaceAll("\n", "n\n");
        String[] lines = str.split("\n");

        walls = new ArrayList<>();
        List<String> prevMapElements = null;

        for(int i = 0; i< lines.length; i++){
            String[] mapElements = lines[i].split("\\t");
            for(int j = 0; j < mapElements.length; j++){
                String elem = mapElements[j];
                if("".equals(elem) || "n".equalsIgnoreCase(elem)){
                    Wall wall = new Wall(blockWidth*j, blockHeight*i, blockHeight*(j+1), blockHeight*(i+1));

                    if(prevMapElements != null && !prevMapElements.get(j).equals("") && !prevMapElements.get(j).equalsIgnoreCase("n")){
                        wall.setWallTexture();
                    }

                    wall.init(batch);
                    walls.add(wall);
                }else if("P".equals(elem)){
                    Player player = Game.getInstance().getPlayer();
                    player.teleport(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                }else if("Ex".equals(elem)){
                    Exit teleport = new Exit(blockWidth*j, blockHeight*i );
                    teleport.init(batch);
                    Game.getInstance().getCollisionController().addAutoUsableObject(teleport);
                }else if("Key".equals(elem)){
                    KeyItem keyItem = new KeyItem();
                    keyItem.init(batch);
                    keyItem.setXY(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                    Game.getInstance().getCollisionController().addUsableObject(keyItem);
                }else if("G".equals(elem)){
                    Ghost ghost = new Ghost();
                    ghost.init(batch);
                    ghost.getXY().x = blockWidth*j + blockWidth/2;
                    ghost.getXY().y = blockHeight*i + blockHeight/2;
                    Game.getInstance().getCollisionController().addEnemy(ghost);
                }else if("L".equals(elem)){
                    OilLampItem oilLampItem = new OilLampItem();
                    oilLampItem.init(batch);
                    oilLampItem.setXY(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                    Game.getInstance().getCollisionController().addUsableObject(oilLampItem);
                }else if("R".equals(elem)) {
                    FlareGunItem flareGunItem = new FlareGunItem();
                    flareGunItem.init(batch);
                    flareGunItem.setXY(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                    Game.getInstance().getCollisionController().addUsableObject(flareGunItem);
                }else if("C".equals(elem)) {
                    CompassItem compassItem = new CompassItem();
                    compassItem.init(batch);
                    compassItem.setXY(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                    Game.getInstance().getCollisionController().addUsableObject(compassItem);
                }
            }
            prevMapElements = Arrays.asList(mapElements);
        }

    }

    public void draw(){
        for(Wall wall : walls){
            wall.draw();
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }
}
