package jogo;

import java.util.Random;
import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;
import scn.A;
import sprite.C;
import java.net.URL;

public class Cenario1 extends Transicao {

    private final Window janela;
    private final Scene cena;
    private final Jogador jogador;
    private final Keyboard teclado;
    private final Inimigo zumbi[];
    private final Util util = new Util();

    public Cenario1(Window window) {       
        URL a = A.class.getResource(("cenario.scn"));
        URL b = C.class.getResource("jogador.png");
        janela = window;
        cena = new Scene();
        cena.loadFromFile((util.arrumaUrl(a)));
        jogador = new Jogador(700, 1155, util.arrumaUrl(b));
        zumbi = new Inimigo[50];
        teclado = janela.getKeyboard();
        som.play("musica.wav");
        rum();
    }

    public void rum() {
        URL a = C.class.getResource("zumbi.png");
        Random ran = new Random();
        for (int i = 0; i < zumbi.length; i++) {
            int posicao = -1000 + ran.nextInt(2000);
            int posicao2 = -1000 + ran.nextInt(2000);
            zumbi[i] = new Inimigo(posicao, posicao2, util.arrumaUrl(a));

        }

        while (true) {
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                int resposta = 0;
                resposta = JOptionPane.showConfirmDialog(null, "Deseja sair do jogo");
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            jogador.Controle(janela, teclado);
            jogador.caminho(cena);
            cena.moveScene(jogador);
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            jogador.draw();
            jogador.energia(janela);

            for (int i = 0; i < zumbi.length; i++) {
                zumbi[i].caminho(cena);
                zumbi[i].perseguir(jogador.x, jogador.y);
                zumbi[i].x += cena.getXOffset();
                zumbi[i].y += cena.getYOffset();
                zumbi[i].draw();
                jogador.Atirar(janela, cena, teclado, zumbi[i]);
                zumbi[i].atacar(jogador);
                zumbi[i].morrer();

            }
            janela.update();
        }
    }

}
