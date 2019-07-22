package Lerarquivotxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArquivoTxt {

    public static void main(String[] args) {
        ArquivoTxt tex = new ArquivoTxt();
        tex.LerArquivoTxt2();
    }

    public void LerArquivoTxt() {
        InputStream fonte = ArquivoTxt.class.getResourceAsStream("teste.txt");
        InputStreamReader isr = new InputStreamReader(fonte);
        BufferedReader br = new BufferedReader(isr);
        try {
            String s = br.readLine();
            System.out.println(s);
        } catch (IOException ex) {
            System.out.println("Erro " + ex);
        }
    }

    public void LerArquivoTxt2() {
        String s = null;
        for (int i = 1; i < 12; i++) {
            InputStream fonte = ArquivoTxt.class.getResourceAsStream(i + ".txt");
            InputStreamReader isr = new InputStreamReader(fonte);
            BufferedReader br = new BufferedReader(isr);
            try {
                if (s == null) {
                    s = br.readLine();
                } else {
                    s += br.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Erro " + ex);
            }
        }
        System.out.println(s);
    }
}
