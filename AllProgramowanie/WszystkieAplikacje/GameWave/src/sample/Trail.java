package sample;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Trail extends GameObject {

    private float alpha = 1;
    private final Handler handler;
    private final Color color;
    private final int height;
    private final int width;
    private final float lifeTrail;


    public Trail(int x, int y, ID id, Handler handler, Color color, int height, int width, float lifeTrail) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.height = height;
        this.width = width;
        this.lifeTrail = lifeTrail;
    }

    @Override
    public void tick() {
        if (alpha < lifeTrail) {
            handler.removeObject(this);
        }
        alpha -= lifeTrail - 0.001f;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        graphics2D.setComposite(makeTransparent(1));

    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

}
