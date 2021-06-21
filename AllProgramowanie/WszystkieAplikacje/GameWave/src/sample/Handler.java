package sample;

import java.awt.Graphics;
import java.util.LinkedList;

//Handler is for handling render (for example graphics) and tick (for example moving)
//It's for fluent refreshing the game images and objects
public class Handler {

    //We are handling ALL OBJECTS in game. For exmaple in our board.
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject gameObject){
        this.objects.add(gameObject);
    }

    public void removeObject(GameObject gameObject){
        this.objects.remove(gameObject);
    }


}
