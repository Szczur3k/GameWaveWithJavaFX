package sample;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    //What will you do when u press a key
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        //Check all the objects on the board
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            //If that object is a player then do this
            if (tempObject.getId() == ID.PLAYER) {
                //do something

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
            }
        }

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            //If that object is a player then do this
            if (tempObject.getId() == ID.PLAYER) {
                //do something

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);

            }
        }
    }
}
