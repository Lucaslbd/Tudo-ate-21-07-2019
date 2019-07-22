package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTHH = 400;
    public static final int HEIGTHH = 400;
    private Thread thread;
    private boolean running;
    private long targetTime;
    private Graphics2D graphics2D;
    private BufferedImage bufferedImage;
    private int dx, dy;
    private boolean up, down, left, rigth, start;
    private final int SIZE = 10;
    Entity head;
    ArrayList<Entity> snake;

    public GamePanel() {
        iniciar();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    private void setFPS(int fps) {
        targetTime = 1000 / fps;
    }

    private void iniciar() {
        setPreferredSize(new Dimension(WIDTHH, HEIGTHH));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    @Override
    public void run() {
        if (running) {

        } else {
            init();
            long startTime;
            long elapsed;
            long wait;
            while (running) {
                startTime = System.nanoTime();
                update();
                requestRender();
                elapsed = System.nanoTime() - startTime;
                wait = targetTime - elapsed / 1000000;
                if (wait > 0) {
                    try {
                        Thread.sleep(wait);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    private void update() {
        if (up && dy == 0) {
            dy = SIZE;
            dx = 0;
        }
        if (down && dy == 0) {
            dy = -SIZE;
            dx = 0;
        }
        if (left && dx == 0) {
            dy = 0;
            dx = -SIZE;
        }
        if (rigth && dx == 0) {
            dy = 0;
            dx = SIZE;
        }  
        for(int i = snake.size() - 1; i>0;i--){
            snake.get(i).setPosition(snake.get(i - 1).getX(), snake.get(i - 1).getY());
        }
        head.move(dx, dy);
        if(head.getX() < 0)head.setX(WIDTHH);
        if(head.getY() < 0)head.setY(HEIGTHH);
        if(head.getX() > WIDTHH)head.setX(0);
        if(head.getY() < HEIGTHH)head.setY(0);
    }

    private void requestRender() {
        render(graphics2D);
        Graphics g = getGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
        g.dispose();
    }

    public void render(Graphics2D graphics) {
        graphics2D.clearRect(0, 0, WIDTHH, HEIGTHH);
        graphics.setColor(Color.red);
        for (Entity e : snake) {
            e.render(graphics2D);
        }
    }

    private void init() {
        bufferedImage = new BufferedImage(WIDTHH, HEIGTHH, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();
        running = true;
        setUpleval();
        setFPS(10);
    }

    private void setUpleval() {
        snake = new ArrayList<>();
        head = new Entity(SIZE);
        head.setPosition(WIDTHH / 2, HEIGTHH / 2);
        snake.add(head);
        for (int i = 1; i < 10; i++) {
            Entity e = new Entity(SIZE);
            e.setPosition(head.getX() + (i * SIZE), head.getY());
            snake.add(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_UP) {
            up = true;
        }
        if (k == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (k == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (k == KeyEvent.VK_RIGHT) {
            rigth = true;
        }
        if (k == KeyEvent.VK_ENTER) {
            start = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_UP) {
            up = false;
        }
        if (k == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (k == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (k == KeyEvent.VK_RIGHT) {
            rigth = false;
        }
        if (k == KeyEvent.VK_ENTER) {
            start = false;
        }
    }
}
