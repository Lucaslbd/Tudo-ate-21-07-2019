package br.states;

import br.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class FPState implements State {

    private long now;
    private long lastTime = System.nanoTime();
    private double timer = 0;
    private int tick = 0;
    private int t;

    @Override
    public void init() {

    }

    @Override
    public void update() {
        now = System.nanoTime();
        timer += now - lastTime;
        lastTime = now;
        tick++;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGTH);
        if (timer >= 1000000000) {
            t = tick;
            tick = 0;
            timer = 0;
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 12));
        String text = "TPS: " + t;
        g.drawString(text,g.getFontMetrics().stringWidth(text),g.getFontMetrics(g.getFont()).getHeight());
    }

    @Override
    public void KeyPressed(int cod) {
        System.out.println("Pressionou: " + cod);
    }

    @Override
    public void KeyReleased(int cod) {
         System.out.println("Soltou: " + cod);
    }

}
