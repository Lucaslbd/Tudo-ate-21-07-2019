package jogo;

import java.net.URL;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;
import sprite.C;

public class Jogo {   

    public static void main(String[]args) {
        try {
            Window Janela = new Window(1360, 768);
            Util util = new Util();
            URL url = C.class.getResource("menu.png");           
            GameImage plano = new GameImage((util.arrumaUrl(url)));
            Keyboard teclado = Janela.getKeyboard();

            while (true) {
                plano.draw();
                Janela.update();
                if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                    new Cenario1(Janela);
                }
                if (teclado.keyDown(Keyboard.S_KEY)) {
                    System.exit(0);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Deu erro aqui" + ex);
        }
    }
}
