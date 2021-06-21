package sample;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{


    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        velX = 5;
        velY = 7;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT-53){
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH-31){
            velX *= -1;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);
    }
}