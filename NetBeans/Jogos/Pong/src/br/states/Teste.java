package br.states;

import br.Game;
import br.audio.AudioPlayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Teste implements State {
    
    private final Rectangle eu = new Rectangle((Game.WIDTH - 200 + 30) / 2, Game.HEIGTH - 40, 20, 30);
    private boolean jogo = false;
    private final AudioPlayer pong;    

    public Teste() {
        pong = new AudioPlayer("pong.mp3");
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
       
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(10, 0, Game.WIDTH - 10, Game.HEIGTH);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        g.drawString("Lucas Bertoldi Dias", (Game.WIDTH - g.getFontMetrics().stringWidth("Lucas Bertoldi Dias")) / 2, 50);
        g.fill3DRect(eu.x, eu.y, eu.width, eu.height, true);
       
    }

    @Override
    public void KeyPressed(int cod) {
        if (cod == KeyEvent.VK_LEFT && eu.x > 20) {
            eu.x -= 7;
        } else if (cod == KeyEvent.VK_RIGHT && eu.x < Game.WIDTH - (eu.width +10)) {
            eu.x += 10;
        } else if (cod == KeyEvent.VK_A) {
            StateManager.setState(StateManager.MENU);
        } else if (cod == KeyEvent.VK_ENTER) {
            jogo = !jogo;
        }
    }

    @Override
    public void KeyReleased(int cod) {

    }        
}
