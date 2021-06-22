package sample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject implements Bounds {

    private final Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    //Tick is something like you can do in ONE PIXEL
    //You are adding VELOCITY to X and Y. Thats sum up so you will get something like x + x + x + x.
    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 46);
        y = Game.clamp(y, 0, Game.HEIGHT - 70);

        collision();
        doTrail();

    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {

            GameObject tempObject = handler.objects.get(i);
            int enemyWidth = 16;
            int enemyHeight = 16;

            if (tempObject.getId() == ID.BASIC_ENEMY) {
                if (this.getBounds().intersects(tempObject.getBounds(tempObject.x, tempObject.y, enemyWidth, enemyHeight))) {
                    HUD.HEALTH -= 5;
                }
            }

            if (tempObject.getId() == ID.FAST_ENEMY) {
                if (this.getBounds().intersects(tempObject.getBounds(tempObject.x, tempObject.y, enemyWidth, enemyHeight))) {
                    HUD.HEALTH -= 1;
                }
            }

            if (tempObject.getId() == ID.BIG_ENEMY) {
                if (this.getBounds().intersects(tempObject.getBounds(tempObject.x, tempObject.y, enemyWidth, enemyHeight))) {
                    HUD.HEALTH -= 25;
                }
            }

        }
    }

    private void doTrail(){
        int widthOfTrail = 32;
        int heightOfTrail = 32;
        handler.addObject(new Trail(x, y, ID.TRAIL, handler, Color.WHITE, heightOfTrail, widthOfTrail, 0.08f));
    }

}
