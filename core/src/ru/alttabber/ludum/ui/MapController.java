package ru.alttabber.ludum.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.alttabber.ludum.gameobjects.Teleport;
import ru.alttabber.ludum.gameobjects.Wall;
import ru.alttabber.ludum.gameobjects.units.Player;
import ru.alttabber.ludum.memory.GameController;

import java.io.File;
import java.util.ArrayList;
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

        for(int i = 0; i< lines.length; i++){
            String[] mapElements = lines[i].split("\\t");
            for(int j = 0; j < mapElements.length; j++){
                String elem = mapElements[j];
                if("".equals(elem) || "n".equalsIgnoreCase(elem)){
                    Wall wall = new Wall(blockWidth*j, blockHeight*i, blockHeight*(j+1), blockHeight*(i+1));
                    wall.init(batch);
                    walls.add(wall);
                }else if("P".equals(elem)){
                    Player player = GameController.getInstance().getPlayer();
                    player.teleport(blockWidth*j + blockWidth/2 , blockHeight*i + blockHeight/2);
                }else if("Ex".equals(elem)){
                    Teleport teleport = new Teleport(blockWidth*j, blockHeight*i );
                    teleport.init(batch);
                    GameController.getInstance().getCollisionController().addAutoUsableObject(teleport);
                }else if("Key".equals(elem)){

                }
            }
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
