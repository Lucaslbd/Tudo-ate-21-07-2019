package br.states;

import br.Game;
import br.audio.AudioPlayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class LevelOneState implements State {

    private final Rectangle ball = new Rectangle(Game.WIDTH / 2 - 5, Game.HEIGTH / 2 - 5, 10, 10);
    private final Rectangle p1 = new Rectangle(5, (Game.HEIGTH - 100) / 2, 10, 100);
    private final Rectangle p2 = new Rectangle(Game.WIDTH - 15, (Game.HEIGTH - 100) / 2, 10, 100);
    private int moverX = 6, moverY = 6;
    private int score1 = 0, score2 = 0;
    private boolean jogo = false;
    private final AudioPlayer pong;    

    public LevelOneState() {
        pong = new AudioPlayer("pong.mp3");
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        movimentarCPU();
        limits();
        if (jogo) {
            ball.x += moverX;
            ball.y += moverY;
        }
    }

    private void limits() {
        if (ball.x + 15 > Game.WIDTH) {
            score1++;
            jogo = false;
            start();
        }
        if (ball.x < 0) {
            score2++;
            jogo = false;
            start();
        }
        if (ball.y + 15 > Game.HEIGTH) {
            moverY = -6;
            pong.play();
        }
        if (ball.y < 0) {
            moverY = 6;
            pong.play();
        }
        if (p1.intersects(ball) || p2.intersects(ball)) {
            moverX *= -1;
            pong.play();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGTH);
        g.setColor(Color.WHITE);
        Font font = new Font("Arial" + score1, Font.BOLD, 12);
        g.drawString("Você: " + score1, Game.WIDTH * 1 / 4 - g.getFontMetrics().stringWidth("Você: " + score1) / 2, g.getFontMetrics(font).getHeight());
        g.drawString("CPU: " + score2, Game.WIDTH * 3 / 4 - g.getFontMetrics().stringWidth("CPU: " + score2) / 2, g.getFontMetrics(font).getHeight());
        g.fillRect(Game.WIDTH / 2 - 3, 0, 6, Game.HEIGTH);
        g.fill3DRect(ball.x, ball.y, ball.width, ball.height, true);
        g.fill3DRect(p1.x, p1.y, p1.width, p1.height, true);
        g.fill3DRect(p2.x, p2.y, p2.width, p2.height, true);
    }

    @Override
    public void KeyPressed(int cod) {
        if (jogo) {
            if (cod == KeyEvent.VK_UP && p1.y > 0) {
                p1.y -= 5;
            }
            if (cod == KeyEvent.VK_DOWN && p1.y < Game.HEIGTH - p1.height) {
                p1.y += 5;
            }
        }
        if (cod == KeyEvent.VK_ENTER) {
            jogo = !jogo;
        }

    }

    @Override
    public void KeyReleased(int cod) {

    }

    private void movimentarCPU() {
        if ((ball.x > (Game.WIDTH / 2)) && (ball.x > 0)) {
            //movimentar cpu
            if (((ball.y + (ball.height / 2)) > ((p2.y + (p2.height / 2))) + 5)) {
                //mover para baixo
                if ((p2.y + p2.height) <= Game.HEIGTH) {
                    p2.y += 5;
                }
            } else if (((ball.y + (ball.height / 2)) < ((p2.y + (p2.height / 2))) + 5)) {
                //mover para cima                
                p2.y -= 5;
            }
        } else {
            //movimentar cpu para o centro
            if ((p2.y + (p2.height / 2)) < (Game.HEIGTH / 2)) {
                p2.y += 2;
            } else if ((p2.y + (p2.height / 2)) > (p2.height / 2)) {
                p2.y -= 2;
            }
        }
    }

    public void start() {
        Random r = new Random();
        ball.x = Game.WIDTH / 2 - 5;
        ball.y = Game.HEIGTH / 2 - 5;
        moverX = (r.nextInt(2) == 0) ? 5 : -5;
        moverY = (r.nextInt(2) == 0) ? 5 : -5;
        p1.y = (Game.HEIGTH - 100) / 2;
    }

}
