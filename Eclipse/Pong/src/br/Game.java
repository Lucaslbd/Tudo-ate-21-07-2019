package br;

import br.display.Display;
import br.states.StateManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private final Display display;
    private Thread thread;
    private boolean running = false;
    private final StateManager sm;
    public static final int WIDTH = 900, HEIGTH = 500;

    public Game() {
        display = new Display("Pong", WIDTH, HEIGTH);
        sm = new StateManager();
        display.setKeyListener(sm);
        StateManager.setState(StateManager.MENU);
    }

    @Override
    public void run() {
        init();
       // int fps = 60;
        double timerPertick = 1000000000 / 60;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timerPertick;
            lastTime = now;
            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }
        stop();
    }

    public synchronized void start() {
        if (thread != null) {
        } else {
            thread = new Thread(this);
            thread.start();
            running = true;
        }
    }

    public synchronized void stop() {
        if (thread == null) {
        } else {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void init() {

    }

    private void update() {
        if (StateManager.getState() == null) {

        } else {
            sm.update();
        }
    }

    private void render() {
        BufferStrategy bs = display.getBufferStrategy();
        if (bs == null) {
            display.createBufferStrategy();
            bs = display.getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGTH);
        if (StateManager.getState() != null) {
            sm.render(g);
        }
        g.dispose();
        bs.show();
    }
}
