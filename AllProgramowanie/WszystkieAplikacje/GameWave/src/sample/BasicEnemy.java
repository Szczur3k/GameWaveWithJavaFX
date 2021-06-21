package sample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject implements Bounds {

    private final Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 7;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 53) {
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 31) {
            velX *= -1;
        }

        doTrail();
    }

    private void doTrail() {
        int widthOfTrail = 16;
        int heightOfTrail = 16;
        handler.addObject(new Trail(x, y, ID.TRAIL, handler, Color.RED, heightOfTrail, widthOfTrail, 0.035f));
    }

}
