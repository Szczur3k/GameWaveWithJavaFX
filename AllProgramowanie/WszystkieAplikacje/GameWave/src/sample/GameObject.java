package sample;

import java.awt.Graphics;
import java.awt.Rectangle;

// GameObjects that is all things in game. Its abstract because all of the gameObject (for example Player) will have
// size (x,y) speed (velX, velY) and the ID which is enum.
// Thats why it must implement tick and render.
public abstract class GameObject {

    protected int x,y;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public Rectangle getBounds(int x, int y, int width, int height) {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
