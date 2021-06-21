package sample;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }


    //You are adding VELOCITY to X and Y. Thats sum up so you will get something like x + x + x + x.
    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);
    }
}
