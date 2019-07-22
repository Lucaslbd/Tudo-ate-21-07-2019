package jogo;

import java.net.URL;

public class Util {

    public String arrumaUrl(URL c) {
        String caminhoBruto = String.valueOf(c);
        char[] t = caminhoBruto.toCharArray();
        String caminho = String.valueOf(t[10]);
        for (int i = 11; i < t.length; i++) {
            if (String.valueOf(t[i]).equals("/") || String.valueOf(t[i]).equals("\\")) {
                caminho += "\\\\";
            } else if (String.valueOf(t[i]).equals("%")) {
                caminho += " ";
            } else if (String.valueOf(t[i]).equals("2") || String.valueOf(t[i]).equals("0") || String.valueOf(t[i]).equals("!")) {

            } else {
                caminho += String.valueOf(t[i]);
            }
        }
        String caminhoFinal = caminho.replace(".jar", "");
        return caminhoFinal;
    }

    public String arrumaUrl2(URL c) {     
        String caminhoBruto = String.valueOf(c);
        char[] t = caminhoBruto.toCharArray();
        String caminho = String.valueOf(t[10]);
        for (int i = 11; i < t.length; i++) {
            if (String.valueOf(t[i]).equals("/") || String.valueOf(t[i]).equals("\\")) {
                caminho += "/";
            } else if (String.valueOf(t[i]).equals("%")) {
                caminho += " ";
            } else if (String.valueOf(t[i]).equals("2") || String.valueOf(t[i]).equals("0") || String.valueOf(t[i]).equals("!")) {

            } else {
                caminho += String.valueOf(t[i]);
            }
        }
        String caminhoFinal = caminho.replace(".jar", "");       
        return caminhoFinal;
    }
}
