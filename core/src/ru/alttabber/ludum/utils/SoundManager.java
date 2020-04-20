package ru.alttabber.ludum.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import ru.alttabber.ludum.gameobjects.units.Unit;
import ru.alttabber.ludum.memory.Assets;
import ru.alttabber.ludum.memory.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoundManager {

    Sound whiteNoise1;
    Sound whiteNoise2;
    Sound whiteNoise3;

    Sound lampOilSound;
    Sound flareSound;
    Sound compassSound;

    // 0-100
    float whiteNoiseLevel = 0;
    float maxVolume_whiteNoise1 = 0.2f;
    float maxVolume_whiteNoise2 = 0.2f;
    float maxVolume_whiteNoise3 = 0.2f;

    float whiteNoise_threshold1 = 1;
    float whiteNoise_threshold2 = 20;
    float whiteNoise_threshold3 = 50;
    float whiteNoise_threshold4 = 100;

    float volume_whiteNoise1 = 0;
    float volume_whiteNoise2 = 0;
    float volume_whiteNoise3 = 0;

    float minDistance = 1200;
    float maxDistance = 500;

    long whiteNoise1_id;
    long whiteNoise2_id;
    long whiteNoise3_id;

    Sound randomNoise1;
    Sound randomNoise2;
    Sound randomNoise3;
    Sound randomNoise4;
    Sound randomNoise5;

    float[] randomNoise_volumes = {0.3f, 0.3f, 0.1f, 0.3f, 0.3f};

    float minTime = 5;
    float nextDelay = 5;

    List<Sound> randomNoises = new ArrayList<>();

    public void init(){
        whiteNoise1 = Game.getInstance().getAssetManager().get(Assets.ghostNoise1, Sound.class);
        whiteNoise2 = Game.getInstance().getAssetManager().get(Assets.ghostNoise2, Sound.class);
        whiteNoise3 = Game.getInstance().getAssetManager().get(Assets.ghostNoise3, Sound.class);

        lampOilSound = Game.getInstance().getAssetManager().get(Assets.lampOilSound, Sound.class);
        flareSound = Game.getInstance().getAssetManager().get(Assets.flareSound, Sound.class);
        compassSound = Game.getInstance().getAssetManager().get(Assets.compassSound, Sound.class);

        randomNoise1 = Game.getInstance().getAssetManager().get(Assets.randomNoise1, Sound.class);
        randomNoise2 = Game.getInstance().getAssetManager().get(Assets.randomNoise2, Sound.class);
        randomNoise3 = Game.getInstance().getAssetManager().get(Assets.randomNoise3, Sound.class);
        randomNoise4 = Game.getInstance().getAssetManager().get(Assets.randomNoise4, Sound.class);
        randomNoise5 = Game.getInstance().getAssetManager().get(Assets.randomNoise5, Sound.class);

        randomNoises.add(randomNoise1);
        randomNoises.add(randomNoise2);
        randomNoises.add(randomNoise3);
        randomNoises.add(randomNoise4);
        randomNoises.add(randomNoise5);
    }

    public void playWhiteNoise(){
        whiteNoise1_id = whiteNoise1.loop(volume_whiteNoise1);
        whiteNoise2_id = whiteNoise2.loop(volume_whiteNoise2);
        whiteNoise3_id = whiteNoise3.loop(volume_whiteNoise3);
    }

    public void setNoiseLevel(float level){
        this.whiteNoiseLevel = level;
        if(level <= 0) this.whiteNoiseLevel = 0;
        if(level > 100) this.whiteNoiseLevel = 100;

        if(whiteNoiseLevel >= whiteNoise_threshold1 && whiteNoiseLevel < whiteNoise_threshold2){
            volume_whiteNoise1 = maxVolume_whiteNoise1*whiteNoiseLevel/(whiteNoise_threshold2 - whiteNoise_threshold1);
        }else if(whiteNoiseLevel >= whiteNoise_threshold2 && whiteNoiseLevel < whiteNoise_threshold3){
            volume_whiteNoise1 = maxVolume_whiteNoise1;
            volume_whiteNoise2 = maxVolume_whiteNoise2*(whiteNoiseLevel-whiteNoise_threshold2)/(whiteNoise_threshold3 - whiteNoise_threshold2);
        }else if(whiteNoiseLevel >= whiteNoise_threshold3 && whiteNoiseLevel <= whiteNoise_threshold4){
            volume_whiteNoise1 = maxVolume_whiteNoise1;
            volume_whiteNoise2 = maxVolume_whiteNoise2;
            volume_whiteNoise3 = maxVolume_whiteNoise3*(whiteNoiseLevel-whiteNoise_threshold3)/(whiteNoise_threshold4 - whiteNoise_threshold3);
        }

        whiteNoise1.setVolume(whiteNoise1_id, volume_whiteNoise1);
        whiteNoise2.setVolume(whiteNoise2_id, volume_whiteNoise2);
        whiteNoise3.setVolume(whiteNoise3_id, volume_whiteNoise3);
    }

    public void updateSounds(){
        float enemyDistance = getMinEnemyDistance();
        System.out.println(this.whiteNoiseLevel);
        if(enemyDistance < minDistance){
            setNoiseLevel(whiteNoise_threshold4 * (enemyDistance - minDistance)/(maxDistance - minDistance));
        }else{
            setNoiseLevel(0);
        }
        nextDelay -= Gdx.graphics.getDeltaTime();
        if(nextDelay <= 0){
            playRandomNoise();
            nextDelay = minTime + new Random().nextFloat()*5;
        }
    }

    public float getMinEnemyDistance(){
        float minDistance = 30000000;
        for(Unit enemy: Game.getInstance().getCollisionController().getEnemies()){
            float distance = enemy.getSpriteCenter().dst(Game.getInstance().getPlayer().getSpriteCenter());
            if(distance < minDistance){
                minDistance = distance;
            }
        }
        return minDistance;
    }

    public void playLampOilSound(){
        lampOilSound.play(0.5f);
    }

    public void playFlareSound(){
        flareSound.play(0.5f);
    }

    public void playCompassSound(){
        compassSound.play(0.5f);
    }

    public void playRandomNoise(){
        Random rnd = new Random();
        int soundNumber = rnd.nextInt(randomNoises.size());
        randomNoises.get(soundNumber).play(randomNoise_volumes[soundNumber]);
    }

}
