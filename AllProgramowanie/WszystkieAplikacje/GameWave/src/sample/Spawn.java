package sample;

import sample.Enemies.BasicEnemy;
import sample.Enemies.BigEnemy;
import sample.Enemies.FastEnemy;

import java.util.Random;

public class Spawn {

    private final Handler handler;
    private final HUD hud;
    private int scoreKeep = 0;
    private final Random random = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;

        if (scoreKeep >= 200){
            int actualLevelEnemy = hud.getLevel();
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel()%5==0){
                handler.addObject(new BigEnemy(random.nextInt(Game.WIDTH - 35), random.nextInt(Game.HEIGHT - 35), ID.BIG_ENEMY, handler ));
            }
            if (hud.getLevel()%5!=0) {
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 35), random.nextInt(Game.HEIGHT - 35), ID.BASIC_ENEMY, handler));
            }
            if (hud.getLevel()%9==0){
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 35), random.nextInt(Game.HEIGHT - 35), ID.FAST_ENEMY, handler ));
            }
        }

    }



}
