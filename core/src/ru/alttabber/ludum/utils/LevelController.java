package ru.alttabber.ludum.utils;

import ru.alttabber.ludum.scene.GameOverScene;
import ru.alttabber.ludum.scene.Scene;
import ru.alttabber.ludum.scene.SecondScene;
import ru.alttabber.ludum.scene.StartScene;

import java.util.ArrayList;
import java.util.List;

public class LevelController {

    List<Scene> scenes;
    Scene currentLevel;

    public LevelController() {
        this.scenes = new ArrayList<>();
        this.scenes.add(new StartScene());
        this.scenes.add(new SecondScene());
        this.scenes.add(new GameOverScene());
    }

    public Scene chooseLevel(Class<? extends Scene> sceneClass){
        for(Scene scene : scenes){
            if(scene.getClass() == sceneClass){
                currentLevel = scene;
                return scene;
            }
        }
        currentLevel = null;
        return null;
    }

    public Scene getCurrentLevel() {
        return currentLevel;
    }
}
