package sample;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 200;
    private int score = 0;
    private int level = 1;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void tick(){
        //health cant go beyond 0 or 100.
        HEALTH = Game.clamp(HEALTH, 0, 200);
        score++;
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(15,15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15,15, HEALTH, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15,15, 200, 32);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(HEALTH), 100,35);

        g.drawString("Score: " + score, 10, 68);
        g.drawString("Level: " + level, 10, 88);
    }

}
