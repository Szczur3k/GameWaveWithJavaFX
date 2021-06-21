package sample;

import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.TextArea;

public class HUD {

    public static int HEALTH = 200;

    public void tick(){
        //health cant go beyond 0 or 100.
        HEALTH = Game.clamp(HEALTH, 0, 200);
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(15,15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15,15, HEALTH, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15,15, 200, 32);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(HEALTH), 100,35);

    }

}
