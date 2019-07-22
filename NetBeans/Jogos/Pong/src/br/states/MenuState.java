package br.states;

import br.Game;
import br.audio.AudioPlayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState implements State {

    private Font font1, font2;
    private final String[] options = {"Iniciar", "Exit"};
    private int choice;
    private int x = 0, y = 0, moverX = 2, moverY = 2;
    private final AudioPlayer musica;

    public MenuState() {
        musica = new AudioPlayer("theblackframe.mp3");
        musica.play();
    }

    @Override
    public void init() {
        font1 = new Font("Dialog", Font.PLAIN, 48);
        font2 = new Font("Dialog", Font.PLAIN, 24);
    }

    @Override
    public void update() {
        x += moverX;
        y += moverY;
        limits();
    }

    private void limits() {
        if (x + 15 > Game.WIDTH) {
            moverX = -2;
        }
        if (x < 10) {
            moverX = 2;
        }
        if (y + 15 > Game.HEIGTH) {
            moverY = -2;
        }
        if (y < 0) {
            moverY = 2;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(10, 0, Game.WIDTH - 10, Game.HEIGTH);
        g.setColor(Color.WHITE);
        g.setFont(font1);
        g.drawString("PONG", (Game.WIDTH - g.getFontMetrics().stringWidth("PONG")) / 2, Game.HEIGTH * 1 / 4 + g.getFontMetrics(font1).getHeight());
        g.setFont(font2);
        for (int i = 0; i < options.length; i++) {
            g.setColor(Color.WHITE);
            if (i == choice) {
                g.setColor(Color.YELLOW);
            }
            g.drawString(options[i], (Game.WIDTH - g.getFontMetrics().stringWidth(options[i])) / 2, Game.HEIGTH * 2 / 4 + g.getFontMetrics(font2).getHeight() * i);
        }
        g.setColor(Color.WHITE);
        g.fill3DRect(x, y, 15, 15, true);
    }

    @Override
    public void KeyPressed(int cod) {

    }

    @Override
    public void KeyReleased(int cod) {
        if (cod == KeyEvent.VK_UP) {
            choice--;
            if (choice < 0) {
                choice = options.length - 1;
            }
        }
        if (cod == KeyEvent.VK_DOWN) {
            choice++;
            if (choice > options.length - 1) {
                choice = 0;
            }
        }
        if (cod == KeyEvent.VK_ENTER) {
            select();
        }
    }

    private void select() {
        switch (choice) {
            case 0:
                musica.stop();
                StateManager.setState(StateManager.LEVEL1);
                break;                   
            case 1:
                System.exit(0);
                break;
        }
    }

}
