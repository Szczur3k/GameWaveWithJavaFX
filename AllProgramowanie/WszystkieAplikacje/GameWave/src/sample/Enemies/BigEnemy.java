package sample.Enemies;

import sample.Bounds;
import sample.Game;
import sample.GameObject;
import sample.Handler;
import sample.ID;
import sample.Trail;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BigEnemy extends GameObject implements Bounds {

    private final Handler handler;

    public BigEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 1;
        velY = 1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 64, 64);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        //dont go beyond board height
        if (y <= 0 || y >= Game.HEIGHT - 53) {
            velY *= -1;
        }

        //dont go beyond board width
        if (x <= 0 || x >= Game.WIDTH - 31) {
            velX *= -1;
        }

        doTrail();
    }

    private void doTrail() {
        int widthOfTrail = 64;
        int heightOfTrail = 64;
        handler.addObject(new Trail(x, y, ID.TRAIL, handler, Color.GREEN, heightOfTrail, widthOfTrail, 0.05f));
    }

}
