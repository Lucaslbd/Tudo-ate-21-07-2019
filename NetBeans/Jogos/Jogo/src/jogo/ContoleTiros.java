package jogo;

import audio.B;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.LinkedList;
import jplay.Scene;
import jplay.Sound;
import jplay.Window;
import sprite.C;

public class ContoleTiros {

    LinkedList<Tiro> tiros = new LinkedList<>();

    public void adicionaTiro(double x, double y, int caminho, Scene cena) {
        Util util = new Util();
        URL a = C.class.getResource("f.png");
        Tiro tiro = new Tiro(x, y, caminho, util.arrumaUrl(a));
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }
    int cont = 0;
    int controle = 0;

    public void rum(ator inimigo, Window janela) {
        Font f = new Font("arial", Font.BOLD, 30);

        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
            if (tiro.collided(inimigo)) {
                tiro.x = 10000_000;
                Inimigo.energia -= 250;
                controle++;
                if (controle == 4) {
                    cont++;
                    controle = 0;
                }
            }
        }
        janela.drawText("Mortos: " + cont, 500, 30, Color.yellow, f);

    }

    private void somDisparo() {
        Util util = new Util();
        URL c = B.class.getResource("tiro.wav");
        new Sound(util.arrumaUrl(c)).play();
    }

}
