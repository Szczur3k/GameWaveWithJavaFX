package sample;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private final Handler handler;
    private final Random r = new Random();
    private final HUD hud;

    public Game() {
        //Handler is must to initialize beacuse we call it in render() method
        handler = new Handler();

        //We are using keys so LISTEN for it
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's Build a Game", this);

        hud = new HUD();

        //Set object to handler. Player is created and given to the stage

        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.PLAYER, handler));

        for (int i = 0; i < 10; i++) {
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BASIC_ENEMY, handler));
        }

    }

    //Starting the game with 1 thread. This could be run on multithreading for saving memory
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    //method for stoping the game. Thread.join is stoping the thread
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Thats method for calling FPS, times and keep everything fluent
    @Override
    public void run() {
        //request focus focus on the window so you dont need to click it to move player or anything else
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running) {
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }

            if (HUD.HEALTH == 0) running = false;
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    public static int clamp(int variable, int min, int max) {
        if (variable >= max) return variable = max;
        if (variable <= min) return variable = min;
        return variable;
    }

    private void collision(){

    }

    public static void main(String[] args) {
        new Game();
    }
}
