package jogo;

import audio.B;
import java.net.URL;
import jplay.Sound;

public class som {

    private static Sound musica;

    public static void play(String audio) {
        stop();
        Util util = new Util();
        URL c = B.class.getResource("musica.wav");
        musica = new Sound(util.arrumaUrl(c));

        som.musica.play();
        som.musica.setRepeat(true);
    }

    public static void stop() {
        if (som.musica != null) {
            musica.stop();
        }
    }

}
